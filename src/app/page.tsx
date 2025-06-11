import Navbar from "../components/Navbar";
import { projects } from "../data/projects";
import Image from "next/image";
import { FiGithub, FiInstagram } from "react-icons/fi";

export default function Home() {
  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar />

      {/* El Hero Section */}
      <section
  className="relative flex items-center justify-center p-4 min-h-[80vh] bg-cover bg-center bg-no-repeat"
  style={{
    backgroundImage: "url('/images/narutoShippudenManga2.jpg')",
    backgroundSize: "cover", // Horizontal
    backgroundPosition: "center 30%", // Vertical
  }}
>
        <div className="absolute inset-0 bg-black/50" />
        <div className="relative z-10 text-center">
          <Image
            src="/images/dekuicon.jpg"
            alt="Icono de Deku"
            width={150}
            height={150}
            className="mx-auto rounded-full border-4 border-red-500 mb-6"
          />
          <h1 className="text-5xl font-bold text-white mb-4">
            Hey, Im Aaron Farias
          </h1>
          <p className="text-2xl text-red-300">
            UVAQ Student at Systems Engineering and Computer Security
          </p>
          
          {/* Redes Sociales */}
          <div className="mt-8 flex justify-center space-x-8">
            <a 
              href="https://github.com/aaronIvanFarias" 
              target="_blank"
              rel="noopener noreferrer"
              className="text-white hover:text-red-400 transition-colors"
            >
              <FiGithub size={32} />
            </a>
            <a
              href="https://instagram.com/dar_kusanagi"
              target="_blank"
              rel="noopener noreferrer"
              className="text-white hover:text-red-400 transition-colors"
            >
              <FiInstagram size={32} />
            </a>
          </div>
        </div>
      </section>

      {/* Mis Proyectos */}
      <section id="projects" className="py-16 px-4 sm:px-6 lg:px-8 bg-gray-200">
        <div className="max-w-7xl mx-auto">
          <h2 className="text-4xl font-bold text-center mb-12 text-gray-800">
            My Projects
          </h2>
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
            {projects.map((project) => (
              <div key={project.id} className="bg-white rounded-lg overflow-hidden shadow-lg hover:shadow-xl transition-shadow">
                <Image
                  src={project.image}
                  alt={project.title}
                  width={600}
                  height={400}
                  className="w-full h-64 object-cover"
                />
                <div className="p-6">
                  <h3 className="font-bold text-xl text-gray-800">{project.title}</h3>
                  <p className="mt-2 text-gray-600">{project.description}</p>
                  <a
                    href={project.codeUrl}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="mt-4 inline-block px-4 py-2 bg-red-500 text-white rounded hover:bg-red-600"
                  >
                    View on GitHub
                  </a>
                </div>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Sobre mi */}
      <section id="about" className="py-20 px-4 sm:px-6 lg:px-8 bg-white">
        <div className="max-w-5xl mx-auto">
          <h2 className="text-4xl font-bold text-center mb-12 text-gray-800">
            About Me
          </h2>
          <div className="grid md:grid-cols-2 gap-12">
            <div>
              <p className="text-lg text-gray-700 mb-6">
                Whats up? Im studying Systems Engineering and Computer Security at UVAQ. 
                My hobbies are playing video games, watching movies, learning about history, and practicing martial arts.
              </p>
              <p className="text-lg text-gray-700 mb-6">
                BTW, I got a pretty girlfriend, a loving family and loyal friends.
              </p>
            </div>
            <div>
              <h3 className="text-2xl font-semibold mb-4 text-gray-800">My Skills and Experience</h3>
              <div className="flex flex-wrap gap-3">
                {["Java", "HTML", "Systems Design", "English/Spanish", "Problem Solving", "Teamwork", "Continuous Learning", "Gamer", "Geek", "Amateur Drawing and Design", "History Enjoyer"].map((skill) => (
                  <span
                    key={skill}
                    className="px-4 py-2 bg-gray-100 text-gray-800 rounded-full"
                  >
                    {skill}
                  </span>
                ))}
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* Mi Contacto */}
      <section id="contact" className="py-16 px-4 sm:px-6 lg:px-8 bg-gray-100">
        <div className="max-w-md mx-auto">
          <h2 className="text-4xl font-bold text-center mb-8 text-gray-800">
            Contact
          </h2>
          <form
            action="https://formsubmit.co/faaronivan@gmail.com"
            method="POST"
            className="space-y-6"
          >
            <input type="hidden" name="_captcha" value="false" />
            <input type="hidden" name="_template" value="box" />
            
            <div>
              <input
                type="text"
                name="name"
                placeholder="Your Name"
                required
                className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-red-500"
              />
            </div>

            <div>
              <input
                type="email"
                name="email"
                placeholder="Your Email"
                required
                className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-red-500"
              />
            </div>

            <div>
              <textarea
                name="message"
                placeholder="Your Message"
                rows={5}
                required
                className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-red-500"
              ></textarea>
            </div>

            <button
              type="submit"
              className="w-full px-4 py-2 bg-red-500 text-white font-medium rounded-md hover:bg-red-600 focus:outline-none focus:ring-2 focus:ring-red-500"
            >
              Send Message
            </button>
          </form>
        </div>
      </section>
    </div>
  );
}
