/** @type {import('next').NextConfig} */
const nextConfig = {
  experimental: {
    appDir: true,
  },
  webpack: (config) => {
    // Add support for Monaco Editor
    config.module.rules.push({
      test: /\.ttf$/,
      type: 'asset/resource',
    })
    return config
  },
  env: {
    DEDUKT_API_URL: process.env.DEDUKT_API_URL || 'http://localhost:8080',
    DEDUKT_WS_URL: process.env.DEDUKT_WS_URL || 'ws://localhost:8080/ws',
  },
}

module.exports = nextConfig
