import { cn } from '@/lib/utils'
import type { Metadata } from 'next'
import { Playfair_Display, Lato } from 'next/font/google'

import './globals.css'

const fontSerif = Playfair_Display({
  subsets: ['latin'],
  variable: '--font-serif',
  weight: ['400', '600', '700'],
})
const fontSans = Lato({
  subsets: ['latin'],
  variable: '--font-sans',
  weight: '400',
})

export const metadata: Metadata = {
  title: 'Dogs App',
  description: 'A simple CRUD example app',
}

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode
}>) {
  return (
    <html lang="en">
      <body
        className={cn(
          'min-h-screen font-sans antialiased',
          fontSerif.variable,
          fontSans.variable
        )}
      >
        {children}
      </body>
    </html>
  )
}
