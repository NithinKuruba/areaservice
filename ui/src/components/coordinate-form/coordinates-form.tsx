import {
  Button,
  Container,
  TextField,
  Link,
  IconButton,
  Tooltip,
} from '@mui/material';
import { useSnackbar } from 'notistack';
import { useState } from 'react';
import ResultCard from '../result-card';
import MyLocationRoundedIcon from '@mui/icons-material/MyLocationRounded';
import MapRoundedIcon from '@mui/icons-material/MapRounded';
import * as constants from '../../utils/constants';
import { ChsaArea } from '../result-card/result-card';

const CoordinateForm: React.FC = () => {
  const [latitude, setLatitude] = useState<string>('');
  const [longitude, setLongitude] = useState<string>('');
  const [error, setError] = useState<string>('');
  const [chsa, setChsa] = useState<ChsaArea>();
  const { enqueueSnackbar } = useSnackbar();

  const defaultChsaArea = {
    areaCode: '',
    areaName: '',
  };

  const onSubmit = async (event: any) => {
    event?.preventDefault();

    try {
      const res = await fetch(
        `${process.env.NEXT_PUBLIC_AREASERVICE_API_URL}/area/${longitude}+${latitude}`,
        {
          method: 'GET',
          cache: 'no-cache',
          headers: {
            'Content-Type': 'application/text',
          },
        }
      );
      if (!res.ok) {
        let err: string;
        switch (res.status) {
          case 400:
            err = constants.INVALID_LAT_LNG;
            break;
          case 502:
            err = constants.SERVICE_UNAVAILABLE;
            break;
          default:
            err = constants.SOMETHING_WENT_WRONG;
            break;
        }
        setChsa(defaultChsaArea);
        enqueueSnackbar(err, {
          variant: 'error',
          anchorOrigin: {
            vertical: 'bottom',
            horizontal: 'center',
          },
        });
      } else {
        await res.json().then((data) => {
          setChsa({
            areaCode: data[constants.AREA_CODE],
            areaName: data[constants.AREA_NAME],
          });
        });
      }
    } catch (err) {
      enqueueSnackbar(constants.SERVICE_UNAVAILABLE, {
        variant: 'error',
        anchorOrigin: {
          vertical: 'bottom',
          horizontal: 'center',
        },
      });
    }
  };

  const onReset = () => {
    setChsa(defaultChsaArea);
    setLatitude('');
    setLongitude('');
  };

  const insertCurrentLocation = () => {
    navigator.geolocation.getCurrentPosition(function (position) {
      setLatitude(position.coords.latitude.toString());
      setLongitude(position.coords.longitude.toString());
    });
  };

  return (
    <Container>
      <div
        style={{
          display: 'flex',
          flexDirection: 'column',
          height: '100%',
          rowGap: '25px',
        }}
      >
        <div
          style={{
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'center',
          }}
        >
          <TextField
            required
            id="standard-required"
            label="Latitude"
            variant="standard"
            type="number"
            onChange={(val) => setLatitude(val.target.value)}
            value={latitude}
            sx={{ marginRight: 2 }}
            inputProps={{ 'data-testid': 'input-latitude' }}
          />
          <TextField
            required
            id="standard-required"
            label="Longitude"
            variant="standard"
            type="number"
            onChange={(val) => setLongitude(val.target.value)}
            value={longitude}
            inputProps={{ 'data-testid': 'input-longitude' }}
          />
          <Tooltip title="use current location">
            <IconButton onClick={insertCurrentLocation}>
              <MyLocationRoundedIcon sx={{ color: '#001d6e' }} />
            </IconButton>
          </Tooltip>
          <Tooltip title="open map">
            <Link
              href="https://maps.gov.bc.ca/ess/hm/imap4m/?catalogLayers=7705,7706"
              target="_blank"
            >
              <IconButton onClick={insertCurrentLocation}>
                <MapRoundedIcon sx={{ color: '#001d6e' }} />
              </IconButton>
            </Link>
          </Tooltip>
        </div>

        <div style={{ display: 'flex', justifyContent: 'center' }}>
          <Button
            variant="contained"
            sx={{
              backgroundColor: 'darkred',
              '&:hover': { backgroundColor: 'red' },
            }}
            onClick={onReset}
            data-testid="btn-reset"
          >
            Reset
          </Button>
          <Button
            variant="contained"
            sx={{
              backgroundColor: '#001d6e',
              marginLeft: '10px',
            }}
            onClick={onSubmit}
            disabled={!latitude || !longitude}
            data-testid="btn-submit"
          >
            Submit
          </Button>
        </div>
        <div>{chsa?.areaCode && <ResultCard {...chsa} />}</div>
      </div>
    </Container>
  );
};

export default CoordinateForm;
