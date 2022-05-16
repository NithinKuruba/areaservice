module.exports = {
  verbose: true,
  automock: false,
  resetMocks: false,
  testEnvironment: 'jsdom',
  setupFilesAfterEnv: ['./jest.setup.ts'],
  moduleNameMapper: {
    '\\.(css|less)$': '<rootDir>/src/__mocks__/styleMock.ts',
  },
};

export {};
