import { Grid } from '@mui/material';
import type { NextPage } from 'next';
import CoordinateForm from '../components/coordinate-form';
import styles from '../styles/Home.module.css';

const Home: NextPage = () => {
  return (
    <main className={styles.main}>
      <Grid container direction="column" alignItems="center">
        <Grid item>
          <CoordinateForm />
        </Grid>
        <Grid item></Grid>
      </Grid>
    </main>
  );
};

export default Home;
