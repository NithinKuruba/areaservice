import { Paper, Grid, IconButton, Tooltip } from '@mui/material';
import CopyAllRoundedIcon from '@mui/icons-material/CopyAllRounded';
import { RESULT_CARD_TITLE } from '../../utils/constants';

export interface ChsaArea {
  areaCode: string;
  areaName: string;
}

const ResultCard: React.FC<ChsaArea> = (props: ChsaArea) => {
  return (
    <div>
      <Paper
        sx={{
          p: 2,
          display: 'flex',
          flexDirection: 'row',
        }}
      >
        <Grid container direction="column">
          <Grid item>
            <h3>{RESULT_CARD_TITLE}</h3>
          </Grid>
          <Grid item>
            <div style={{ display: 'flex', alignItems: 'center' }}>
              <strong>Code:</strong>
              <p style={{ marginLeft: '10px' }}>{props.areaCode}</p>
              <Tooltip title="copy">
                <IconButton
                  onClick={() => {
                    navigator.clipboard.writeText(props.areaCode);
                  }}
                >
                  <CopyAllRoundedIcon></CopyAllRoundedIcon>
                </IconButton>
              </Tooltip>
            </div>
          </Grid>
          <Grid item>
            <div style={{ display: 'flex', alignItems: 'center' }}>
              <strong>Name:</strong>
              <p style={{ marginLeft: '10px' }}>{props.areaName}</p>
              <Tooltip title="copy">
                <IconButton
                  onClick={() => {
                    navigator.clipboard.writeText(props.areaName);
                  }}
                >
                  <CopyAllRoundedIcon></CopyAllRoundedIcon>
                </IconButton>
              </Tooltip>
            </div>
          </Grid>
        </Grid>
      </Paper>
    </div>
  );
};

export default ResultCard;
