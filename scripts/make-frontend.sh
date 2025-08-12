#!/bin/bash
# DeduKt Frontend Setup Script
# Creates a modern Next.js frontend with TypeScript, TailwindCSS, SASS, and essential tools

set -e

FRONTEND_DIR="./notebook/frontend"
PROJECT_NAME="dedukt-notebook-frontend"

echo "🚀 Setting up DeduKt Frontend with Next.js..."

# Check prerequisites
command -v node >/dev/null 2>&1 || { echo "❌ Node.js is required but not installed. Aborting." >&2; exit 1; }
command -v npm >/dev/null 2>&1 || { echo "❌ npm is required but not installed. Aborting." >&2; exit 1; }

# Create frontend directory if it doesn't exist
mkdir -p "$FRONTEND_DIR"
cd "$FRONTEND_DIR"

echo "📦 Creating Next.js project with TypeScript..."
npx create-next-app@latest . \
  --typescript \
  --tailwind \
  --eslint \
  --app \
  --src-dir \
  --import-alias "@/*" \
  --use-npm

echo "🎨 Installing additional dependencies..."

# UI and Styling
npm install -D sass
npm install @headlessui/react @heroicons/react
npm install clsx class-variance-authority
npm install lucide-react

# Code Editor and Syntax Highlighting
npm install @monaco-editor/react monaco-editor
npm install @uiw/react-codemirror @uiw/codemirror-theme-github
npm install prismjs @types/prismjs

# State Management and Data Fetching
npm install zustand swr
npm install @tanstack/react-query @tanstack/react-query-devtools

# WebSocket and Real-time
npm install socket.io-client

# Math and Visualization
npm install katex @types/katex
npm install plotly.js-dist-min @types/plotly.js
npm install d3 @types/d3

# Forms and Validation
npm install react-hook-form @hookform/resolvers zod

# Development Tools
npm install -D @types/node
npm install -D prettier prettier-plugin-tailwindcss
npm install -D @typescript-eslint/parser @typescript-eslint/eslint-plugin
npm install -D eslint-config-prettier eslint-plugin-prettier
npm install -D husky lint-staged

# Testing
npm install -D jest @testing-library/react @testing-library/jest-dom
npm install -D @testing-library/user-event jest-environment-jsdom

echo "⚙️ Setting up configuration files..."

# Prettier configuration
cat > .prettierrc << 'EOF'
{
  "semi": false,
  "singleQuote": true,
  "tabWidth": 2,
  "trailingComma": "es5",
  "printWidth": 100,
  "plugins": ["prettier-plugin-tailwindcss"]
}
EOF

# Prettier ignore
cat > .prettierignore << 'EOF'
.next/
node_modules/
dist/
build/
coverage/
*.min.js
*.min.css
EOF

# ESLint configuration
cat > .eslintrc.json << 'EOF'
{
  "extends": [
    "next/core-web-vitals",
    "@typescript-eslint/recommended",
    "prettier"
  ],
  "parser": "@typescript-eslint/parser",
  "plugins": ["@typescript-eslint"],
  "rules": {
    "prefer-const": "error",
    "no-var": "error",
    "@typescript-eslint/no-unused-vars": "error",
    "@typescript-eslint/explicit-function-return-type": "off",
    "@typescript-eslint/explicit-module-boundary-types": "off"
  },
  "ignorePatterns": ["node_modules/", ".next/", "dist/"]
}
EOF

# TypeScript configuration enhancement
cat > tsconfig.json << 'EOF'
{
  "compilerOptions": {
    "target": "es5",
    "lib": ["dom", "dom.iterable", "es6"],
    "allowJs": true,
    "skipLibCheck": true,
    "strict": true,
    "noEmit": true,
    "esModuleInterop": true,
    "module": "esnext",
    "moduleResolution": "bundler",
    "resolveJsonModule": true,
    "isolatedModules": true,
    "jsx": "preserve",
    "incremental": true,
    "plugins": [
      {
        "name": "next"
      }
    ],
    "baseUrl": ".",
    "paths": {
      "@/*": ["./src/*"],
      "@/components/*": ["./src/components/*"],
      "@/lib/*": ["./src/lib/*"],
      "@/types/*": ["./src/types/*"],
      "@/hooks/*": ["./src/hooks/*"],
      "@/stores/*": ["./src/stores/*"],
      "@/utils/*": ["./src/utils/*"]
    }
  },
  "include": ["next-env.d.ts", "**/*.ts", "**/*.tsx", ".next/types/**/*.ts"],
  "exclude": ["node_modules"]
}
EOF

# Jest configuration
cat > jest.config.js << 'EOF'
const nextJest = require('next/jest')

const createJestConfig = nextJest({
  dir: './',
})

const customJestConfig = {
  setupFilesAfterEnv: ['<rootDir>/jest.setup.js'],
  testEnvironment: 'jest-environment-jsdom',
  testPathIgnorePatterns: ['<rootDir>/.next/', '<rootDir>/node_modules/'],
  collectCoverageFrom: [
    'src/**/*.{js,jsx,ts,tsx}',
    '!src/**/*.d.ts',
    '!src/**/*.stories.{js,jsx,ts,tsx}',
  ],
}

module.exports = createJestConfig(customJestConfig)
EOF

# Jest setup
cat > jest.setup.js << 'EOF'
import '@testing-library/jest-dom'
EOF

# Tailwind configuration enhancement
cat > tailwind.config.ts << 'EOF'
import type { Config } from 'tailwindcss'

const config: Config = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend: {
      colors: {
        primary: {
          50: '#eff6ff',
          100: '#dbeafe',
          500: '#3b82f6',
          600: '#2563eb',
          700: '#1d4ed8',
          900: '#1e3a8a',
        },
        secondary: {
          50: '#f8fafc',
          100: '#f1f5f9',
          500: '#64748b',
          600: '#475569',
          700: '#334155',
          900: '#0f172a',
        },
      },
      fontFamily: {
        sans: ['Inter', 'system-ui', 'sans-serif'],
        mono: ['JetBrains Mono', 'Fira Code', 'monospace'],
      },
      animation: {
        'fade-in': 'fadeIn 0.5s ease-in-out',
        'slide-up': 'slideUp 0.3s ease-out',
        'pulse-soft': 'pulse 2s cubic-bezier(0.4, 0, 0.6, 1) infinite',
      },
      keyframes: {
        fadeIn: {
          '0%': { opacity: '0' },
          '100%': { opacity: '1' },
        },
        slideUp: {
          '0%': { transform: 'translateY(20px)', opacity: '0' },
          '100%': { transform: 'translateY(0)', opacity: '1' },
        },
      },
    },
  },
  plugins: [
    require('@tailwindcss/forms'),
    require('@tailwindcss/typography'),
  ],
}

export default config
EOF

# Install additional Tailwind plugins
npm install -D @tailwindcss/forms @tailwindcss/typography

# Next.js configuration
cat > next.config.js << 'EOF'
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
EOF

# Environment variables
cat > .env.local << 'EOF'
# DeduKt Backend URLs
NEXT_PUBLIC_DEDUKT_API_URL=http://localhost:8080
NEXT_PUBLIC_DEDUKT_WS_URL=ws://localhost:8080/ws

# Development
NODE_ENV=development
EOF

cat > .env.example << 'EOF'
# DeduKt Backend URLs
NEXT_PUBLIC_DEDUKT_API_URL=http://localhost:8080
NEXT_PUBLIC_DEDUKT_WS_URL=ws://localhost:8080/ws

# Production settings
NODE_ENV=production
EOF

echo "📁 Creating project structure..."

# Create directory structure
mkdir -p src/{components/{ui,notebook,editor,math},lib,hooks,stores,types,utils,styles}

# Global styles with SASS
cat > src/styles/globals.scss << 'EOF'
@tailwind base;
@tailwind components;
@tailwind utilities;

// Import fonts
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@300;400;500;600&display=swap');

// Custom CSS variables
:root {
  --dedukt-primary: theme('colors.primary.600');
  --dedukt-secondary: theme('colors.secondary.600');
  --dedukt-accent: theme('colors.blue.500');
}

// Custom utility classes
@layer components {
  .btn {
    @apply inline-flex items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm transition-colors duration-200;
  }

  .btn-primary {
    @apply btn bg-primary-600 text-white hover:bg-primary-700 focus:ring-2 focus:ring-offset-2 focus:ring-primary-500;
  }

  .btn-secondary {
    @apply btn bg-secondary-100 text-secondary-700 hover:bg-secondary-200 focus:ring-2 focus:ring-offset-2 focus:ring-secondary-500;
  }

  .card {
    @apply bg-white rounded-lg shadow-sm border border-gray-200 p-6;
  }

  .notebook-cell {
    @apply border border-gray-200 rounded-lg mb-4 overflow-hidden transition-all duration-200 hover:shadow-sm;
  }

  .code-editor {
    @apply font-mono text-sm;
  }
}

// Dark mode support
@media (prefers-color-scheme: dark) {
  :root {
    --dedukt-primary: theme('colors.primary.400');
    --dedukt-secondary: theme('colors.secondary.400');
  }

  .card {
    @apply bg-gray-800 border-gray-700 text-gray-100;
  }

  .notebook-cell {
    @apply border-gray-700 bg-gray-800;
  }
}

// KaTeX styles for math rendering
@import 'katex/dist/katex.min.css';

// Monaco Editor theme overrides
.monaco-editor {
  @apply rounded-md;
}

// Custom scrollbars
::-webkit-scrollbar {
  width: 8px;
  height: 8px;
}

::-webkit-scrollbar-track {
  @apply bg-gray-100 rounded-full;
}

::-webkit-scrollbar-thumb {
  @apply bg-gray-300 rounded-full hover:bg-gray-400;
}

// Animation utilities
.fade-in {
  animation: fadeIn 0.5s ease-in-out;
}

.slide-up {
  animation: slideUp 0.3s ease-out;
}
EOF

# Package.json scripts enhancement
cat > package.json.tmp << 'EOF'
{
  "name": "dedukt-notebook-frontend",
  "version": "0.1.0",
  "private": true,
  "scripts": {
    "dev": "next dev",
    "build": "next build",
    "start": "next start",
    "lint": "next lint",
    "lint:fix": "next lint --fix",
    "type-check": "tsc --noEmit",
    "test": "jest",
    "test:watch": "jest --watch",
    "test:coverage": "jest --coverage",
    "format": "prettier --write .",
    "format:check": "prettier --check .",
    "prepare": "husky install"
  }
}
EOF

# Merge scripts into existing package.json
npm pkg set scripts.lint:fix="next lint --fix"
npm pkg set scripts.type-check="tsc --noEmit"
npm pkg set scripts.test:watch="jest --watch"
npm pkg set scripts.test:coverage="jest --coverage"
npm pkg set scripts.format="prettier --write ."
npm pkg set scripts.format:check="prettier --check ."
npm pkg set scripts.prepare="husky install"

# Husky setup for git hooks
npx husky install
npx husky add .husky/pre-commit "lint-staged"
npx husky add .husky/pre-push "npm run type-check && npm run test"

# Lint-staged configuration
cat > .lintstagedrc.json << 'EOF'
{
  "*.{js,jsx,ts,tsx}": [
    "eslint --fix",
    "prettier --write"
  ],
  "*.{json,md,scss,css}": [
    "prettier --write"
  ]
}
EOF

# VS Code settings for the project
mkdir -p .vscode
cat > .vscode/settings.json << 'EOF'
{
  "typescript.preferences.importModuleSpecifier": "relative",
  "editor.formatOnSave": true,
  "editor.defaultFormatter": "esbenp.prettier-vscode",
  "editor.codeActionsOnSave": {
    "source.fixAll.eslint": true
  },
  "emmet.includeLanguages": {
    "typescript": "html",
    "typescriptreact": "html"
  },
  "tailwindCSS.experimental.classRegex": [
    ["cva\\(([^)]*)\\)", "[\"'`]([^\"'`]*).*?[\"'`]"],
    ["cx\\(([^)]*)\\)", "(?:'|\"|`)([^']*)(?:'|\"|`)"]
  ]
}
EOF

# VS Code extensions recommendations
cat > .vscode/extensions.json << 'EOF'
{
  "recommendations": [
    "bradlc.vscode-tailwindcss",
    "esbenp.prettier-vscode",
    "dbaeumer.vscode-eslint",
    "ms-vscode.vscode-typescript-next",
    "formulahendry.auto-rename-tag",
    "christian-kohler.path-intellisense",
    "ms-vscode.vscode-json"
  ]
}
EOF

# Create basic TypeScript types
cat > src/types/index.ts << 'EOF'
// Core DeduKt types
export interface NotebookCell {
  id: string
  type: 'code' | 'markdown' | 'math'
  content: string
  output?: CellOutput[]
  metadata?: Record<string, any>
  createdAt: Date
  updatedAt: Date
}

export interface CellOutput {
  type: 'text' | 'html' | 'image' | 'error' | 'math'
  content: string
  metadata?: Record<string, any>
}

export interface Notebook {
  id: string
  title: string
  cells: NotebookCell[]
  metadata?: Record<string, any>
  createdAt: Date
  updatedAt: Date
}

export interface ExecutionResult {
  success: boolean
  output?: CellOutput[]
  error?: string
  duration?: number
}

// WebSocket message types
export interface WebSocketMessage {
  type: 'cell_execute' | 'cell_update' | 'notebook_update' | 'error'
  payload: any
  timestamp: Date
}

// API response types
export interface ApiResponse<T = any> {
  success: boolean
  data?: T
  error?: string
  message?: string
}

// UI types
export interface EditorTheme {
  name: string
  isDark: boolean
  colors: Record<string, string>
}

export interface UserPreferences {
  theme: 'light' | 'dark' | 'system'
  editorTheme: string
  fontSize: number
  autoSave: boolean
  showLineNumbers: boolean
}
EOF

# Create a basic component example
cat > src/components/ui/Button.tsx << 'EOF'
import { forwardRef, ButtonHTMLAttributes } from 'react'
import { clsx } from 'clsx'
import { cva, type VariantProps } from 'class-variance-authority'

const buttonVariants = cva(
  'inline-flex items-center justify-center rounded-md text-sm font-medium transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:opacity-50 disabled:pointer-events-none',
  {
    variants: {
      variant: {
        default: 'bg-primary-600 text-white hover:bg-primary-700',
        secondary: 'bg-secondary-100 text-secondary-900 hover:bg-secondary-200',
        outline: 'border border-gray-300 bg-white hover:bg-gray-50',
        ghost: 'hover:bg-gray-100 hover:text-gray-900',
        danger: 'bg-red-600 text-white hover:bg-red-700',
      },
      size: {
        sm: 'h-8 px-3 text-xs',
        md: 'h-10 px-4',
        lg: 'h-11 px-6 text-base',
      },
    },
    defaultVariants: {
      variant: 'default',
      size: 'md',
    },
  }
)

export interface ButtonProps
  extends ButtonHTMLAttributes<HTMLButtonElement>,
    VariantProps<typeof buttonVariants> {
  loading?: boolean
}

const Button = forwardRef<HTMLButtonElement, ButtonProps>(
  ({ className, variant, size, loading, children, disabled, ...props }, ref) => {
    return (
      <button
        className={clsx(buttonVariants({ variant, size, className }))}
        ref={ref}
        disabled={disabled || loading}
        {...props}
      >
        {loading && (
          <svg
            className="animate-spin -ml-1 mr-2 h-4 w-4"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
          >
            <circle
              className="opacity-25"
              cx="12"
              cy="12"
              r="10"
              stroke="currentColor"
              strokeWidth="4"
            />
            <path
              className="opacity-75"
              fill="currentColor"
              d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"
            />
          </svg>
        )}
        {children}
      </button>
    )
  }
)

Button.displayName = 'Button'

export { Button, buttonVariants }
EOF

# Create README for the frontend
cat > README.md << 'EOF'
# DeduKt Notebook Frontend

Modern Next.js frontend for the DeduKt interactive notebook interface.

## 🚀 Tech Stack

- **Framework**: Next.js 14 with App Router
- **Language**: TypeScript
- **Styling**: TailwindCSS + SASS
- **UI Components**: Headless UI + Custom components
- **Code Editor**: Monaco Editor / CodeMirror
- **State Management**: Zustand + SWR/React Query
- **Math Rendering**: KaTeX
- **Visualization**: Plotly.js + D3.js
- **Testing**: Jest + React Testing Library
- **Linting**: ESLint + Prettier
- **Git Hooks**: Husky + Lint-staged

## 🛠️ Development

### Prerequisites
- Node.js 18+
- npm or yarn

### Getting Started

```bash
# Install dependencies
npm install

# Start development server
npm run dev

# Build for production
npm run build

# Start production server
npm start
```

### Available Scripts

- `npm run dev` - Start development server
- `npm run build` - Build for production
- `npm run start` - Start production server
- `npm run lint` - Run ESLint
- `npm run lint:fix` - Fix ESLint issues
- `npm run type-check` - Run TypeScript type checking
- `npm run test` - Run tests
- `npm run test:watch` - Run tests in watch mode
- `npm run test:coverage` - Run tests with coverage
- `npm run format` - Format code with Prettier
- `npm run format:check` - Check code formatting

### Environment Variables

Copy `.env.example` to `.env.local` and adjust the values:

```bash
# DeduKt Backend URLs
NEXT_PUBLIC_DEDUKT_API_URL=http://localhost:8080
NEXT_PUBLIC_DEDUKT_WS_URL=ws://localhost:8080/ws
```

## 📁 Project Structure

```
src/
├── app/              # Next.js App Router pages
├── components/       # React components
│   ├── ui/          # Reusable UI components
│   ├── notebook/    # Notebook-specific components
│   ├── editor/      # Code editor components
│   └── math/        # Math rendering components
├── lib/             # Utility libraries
├── hooks/           # Custom React hooks
├── stores/          # State management (Zustand stores)
├── types/           # TypeScript type definitions
├── utils/           # Utility functions
└── styles/          # Global styles and SASS files
```

## 🎨 Styling

This project uses:
- **TailwindCSS** for utility-first styling
- **SASS/SCSS** for complex styles and theming
- **Class Variance Authority** for component variants
- **Headless UI** for accessible components

### Custom Design System

The project includes a custom design system with:
- Consistent color palette
- Typography scale
- Component variants
- Animation utilities
- Dark mode support

## 🧪 Testing

- **Unit tests** with Jest and React Testing Library
- **Type checking** with TypeScript
- **Linting** with ESLint
- **Formatting** with Prettier

Run all checks:
```bash
npm run type-check && npm run lint && npm run test
```

## 🚀 Deployment

The frontend is designed to work with:
- **Vercel** (recommended for Next.js)
- **Netlify**
- **Docker** containers
- Static hosting platforms

Build command: `npm run build`
Output directory: `.next/` (Next.js) or `out/` (static export)

## 🔧 Configuration

### VS Code

The project includes VS Code settings and extension recommendations:
- TailwindCSS IntelliSense
- Prettier formatting
- ESLint integration
- TypeScript support

### Git Hooks

Pre-commit hooks automatically:
- Lint and fix code issues
- Format code with Prettier
- Run type checking
- Run tests before push

## 🤝 Contributing

1. Follow the existing code style
2. Write tests for new features
3. Update documentation
4. Follow conventional commits

## 📝 License

Apache 2.0 - see LICENSE file for details
EOF

echo "✅ Frontend setup complete!"
echo ""
echo "📋 What was installed:"
echo "   • Next.js 14 with TypeScript and App Router"
echo "   • TailwindCSS with custom configuration"
echo "   • SASS/SCSS support"
echo "   • Monaco Editor for code editing"
echo "   • KaTeX for math rendering"
echo "   • Plotly.js and D3.js for visualizations"
echo "   • Zustand for state management"
echo "   • SWR/React Query for data fetching"
echo "   • Jest and React Testing Library for testing"
echo "   • ESLint, Prettier, and Husky for code quality"
echo ""
echo "🚀 Next steps:"
echo "   1. cd $FRONTEND_DIR"
echo "   2. npm run dev"
echo "   3. Open http://localhost:3000"
echo ""
echo "🔧 Development commands:"
echo "   • npm run dev          - Start development server"
echo "   • npm run build        - Build for production"
echo "   • npm run test         - Run tests"
echo "   • npm run lint:fix     - Fix linting issues"
echo "   • npm run format       - Format code"
echo ""