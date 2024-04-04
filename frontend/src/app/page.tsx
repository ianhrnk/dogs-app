'use client'

import RegisterForm from '@/components/RegisterForm'

export default function Home() {
  return (
    <section className="flex min-h-screen items-center justify-center">
      <div className="max-w-[400px]">
        <RegisterForm />
      </div>
    </section>
  )
}
