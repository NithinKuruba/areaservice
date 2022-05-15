import { Paper, Grid, IconButton, Tooltip } from '@mui/material';
import CopyAllRoundedIcon from '@mui/icons-material/CopyAllRounded';

interface DataProps {
  name: string;
}

const ResultCard: React.FC<DataProps> = (props: DataProps) => {
  return (
    <div>
      <Paper
        sx={{
          p: 2,
          display: 'flex',
          flexDirection: 'row',
        }}
      >
        <Grid
          container
          direction="row"
          alignItems="baseline"
          justifyContent="space-evenly"
        >
          <Grid item>
            <h4>CHSA:</h4>
          </Grid>
          <Grid item>
            <p> {props.name}</p>
          </Grid>
          <Grid item>
            <Tooltip title="copy">
              <IconButton
                onClick={() => {
                  navigator.clipboard.writeText(props.name);
                }}
              >
                <CopyAllRoundedIcon></CopyAllRoundedIcon>
              </IconButton>
            </Tooltip>
          </Grid>
        </Grid>
      </Paper>
    </div>
  );
};

export default ResultCard;
