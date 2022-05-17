module.exports = {
  verbose: true,
  automock: false,
  resetMocks: false,
  testEnvironment: 'jsdom',
  setupFilesAfterEnv: ['./jest.setup.ts'],
  collectCoverageFrom: ['<rootDir>/src/**/*.tsx', '<rootDir>/src/**/*.ts'],
  coverageReporters: ['json', 'lcov', 'text'],
  moduleNameMapper: {
    '\\.(css|less)$': '<rootDir>/src/__mocks__/styleMock.ts',
  },
};

export {};
