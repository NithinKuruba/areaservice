import { SnackbarProvider } from 'notistack';
import { render } from '@testing-library/react';

const Providers = ({ children }: any) => {
  return <SnackbarProvider>{children}</SnackbarProvider>;
};

const customRender = (ui: React.ReactElement, options?: any) =>
  render(ui, { wrapper: Providers, ...options });

export { customRender as render };
