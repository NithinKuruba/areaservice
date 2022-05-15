import { AppBar, Box, Toolbar, Typography } from '@mui/material';
import styles from './Header.module.css';

const Header: React.FC = () => {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar
        position="static"
        className={styles.appBar}
        style={{ backgroundColor: '#001d6e' }}
      >
        <Toolbar className={styles.toolBar}>
          <Typography
            variant="h5"
            component="div"
            sx={{ flexGrow: 1, fontWeight: 'bold' }}
            className={styles.title}
          >
            Area Service
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  );
};

export default Header;
