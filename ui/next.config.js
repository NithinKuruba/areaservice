/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  env: {
    NEXT_PUBLIC_AREASERVICE_API_URL: 'http://localhost:8090',
  },
};

module.exports = nextConfig;
