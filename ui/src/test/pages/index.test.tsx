import { render } from '../../__mocks__/utils';
import Home from '../../pages/index';
import fetchMock from '../../__mocks__/fetchMock';
import { fireEvent, waitFor } from '@testing-library/react';
import { INVALID_LAT_LNG } from '../../utils/constants';

beforeEach(() => {
  fetchMock.resetMocks();
});

describe('Home Page', () => {
  it('fetches chsa area code and name for a lat/lng location', async () => {
    fetchMock.mockResponseOnce(
      JSON.stringify({
        cmnty_HLTH_SERV_AREA_CODE: '4111',
        cmnty_HLTH_SERV_AREA_NAME: 'Downtown Victoria/Vic West',
      })
    );

    const { getByText, getByTestId } = render(<Home />);
    expect(getByTestId('input-latitude')).toBeInTheDocument();
    expect(getByTestId('input-longitude')).toBeInTheDocument();
    expect(getByTestId('btn-reset')).toBeInTheDocument();
    expect(getByTestId('btn-submit')).toBeInTheDocument();

    fireEvent.change(getByTestId('input-latitude'), {
      target: { value: '48.4251378' },
    });
    fireEvent.change(getByTestId('input-longitude'), {
      target: { value: '-123.3646335' },
    });
    fireEvent.click(getByTestId('btn-submit'));

    await waitFor(() => {
      expect(getByText('4111')).toBeInTheDocument();
      expect(getByText('Downtown Victoria/Vic West')).toBeInTheDocument();
    });
  });

  it('throws error for an invalid BC lat/lng coordinates', async () => {
    fetchMock.mockResponseOnce('', { status: 400 });

    const { getByText, getByTestId } = render(<Home />);
    expect(getByTestId('input-latitude')).toBeInTheDocument();
    expect(getByTestId('input-longitude')).toBeInTheDocument();
    expect(getByTestId('btn-reset')).toBeInTheDocument();
    expect(getByTestId('btn-submit')).toBeInTheDocument();

    fireEvent.change(getByTestId('input-latitude'), {
      target: { value: '1' },
    });
    fireEvent.change(getByTestId('input-longitude'), {
      target: { value: '1' },
    });
    fireEvent.click(getByTestId('btn-submit'));

    await waitFor(() => {
      expect(getByText(INVALID_LAT_LNG)).toBeInTheDocument();
    });
  });
});
