import '../styles/globals.css';
import type { AppProps } from 'next/app';
import Header from '../components/header';
import { SnackbarProvider } from 'notistack';

const MyApp: React.FC<AppProps> = ({ Component, pageProps }: AppProps) => {
  return (
    <>
      <div>
        <style global jsx>{`
          html,
          body,
          body > div:first-child,
          div#__next,
          div#__next > div {
            height: 100%;
            width: 100%;
          }
        `}</style>
        <Header />
        <SnackbarProvider maxSnack={3}>
          <Component {...pageProps} />
        </SnackbarProvider>
      </div>
    </>
  );
};

export default MyApp;
