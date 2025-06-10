"use client";
import Link from "next/link";

export default function Navbar() {
  return (
    <nav className="bg-white dark:bg-gray-800 shadow-lg p-4 fixed w-full z-10">
      <div className="container mx-auto flex justify-between items-center">
        <Link href="/" className="text-xl font-bold text-red-600 dark:text-red-400">
          Aarón Farías
        </Link>
        <div className="flex items-center space-x-6">
          <Link href="/#projects" className="hover:text-red-500 dark:hover:text-red-400">
            Projects
          </Link>
          <Link href="/#about" className="hover:text-red-500 dark:hover:text-red-400">
            About
          </Link>
          <Link href="/#contact" className="hover:text-red-500 dark:hover:text-red-400">
            Contact
          </Link>
        </div>
      </div>
    </nav>
  );
}