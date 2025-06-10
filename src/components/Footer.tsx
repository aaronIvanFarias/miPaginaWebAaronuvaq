import Link from "next/link";
import { FiGithub, FiInstagram } from "react-icons/fi"; 

export default function Footer() {
  return (
    <footer className="bg-gray-800 text-white py-8 text-center">
      <div className="container mx-auto">
        <p>© {new Date().getFullYear()} Portfolio by Aarón Farías</p>
        
        {/* Contenedor de íconos */}
        <div className="mt-6 flex justify-center space-x-8">
          {/* Enlace a mi GitHub */}
          <Link 
            href="https://github.com/aaronIvanFarias" 
            target="_blank"
            rel="noopener noreferrer"
            className="hover:text-red-500 transition-colors duration-300 flex flex-col items-center"
            aria-label="GitHub"
          >
            <FiGithub size={28} />
            <span className="mt-1 text-sm">GitHub</span>
          </Link>
          
          {/* Enlace a mi Instagram */}
          <Link
            href="https://instagram.com/dar_kusanagi"
            target="_blank"
            rel="noopener noreferrer"
            className="hover:text-red-500 transition-colors duration-300 flex flex-col items-center"
            aria-label="Instagram"
          >
            <FiInstagram size={28} />
            <span className="mt-1 text-sm">Instagram</span>
          </Link>
        </div>
      </div>
    </footer>
  );
}