package com.phonefx.kantadex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CantadaController {

	private List<String> musicas = List.of(
			"https://open.spotify.com/embed/track/0Yz7cszRD3zPCW9SRHdyHm?utm_source=generator",
			"https://open.spotify.com/embed/track/5d6GiLNoY2TVANPfvMASAr?utm_source=generator",
			"https://open.spotify.com/embed/track/46jgYiaKttcuZlpXReHSjx?utm_source=generator",
			"https://open.spotify.com/embed/track/1hGy2eLcmC8eKx7qr1tOqx?utm_source=generator",
			"https://open.spotify.com/embed/track/0prPEidQAOSqaegkhMiVcW?utm_source=generator",
			"https://open.spotify.com/embed/track/5FVd6KXrgO9B3JPmC8OPst?utm_source=generator",
			"https://open.spotify.com/embed/track/1Eeof8IMDWLXEaAtjTW1ny?utm_source=generator",
			"https://open.spotify.com/embed/track/5wWAwzGp2OaaoIkwcz6wZs?utm_source=generator",
			"https://open.spotify.com/embed/track/0LDT8QEHbPA0aawzm9CWP7?utm_source=generator",
			"https://open.spotify.com/embed/track/6QlotyGlpPfEX4eGsvbhCh?utm_source=generator",
			"https://open.spotify.com/embed/track/3apbQXcMP7POf6cgciCWpA?utm_source=generator",
			"https://open.spotify.com/embed/track/0LjY5kfLP4TfD8wX3plY62?utm_source=generator",
			"https://open.spotify.com/embed/track/1ucnuV88gFTfR3BalmznDk?utm_source=generator",
			"https://open.spotify.com/embed/track/5qqabIl2vWzo9ApSC317sa?utm_source=generator",
			"https://open.spotify.com/embed/track/6gHb7VvopmZv8KR31xe6wa?utm_source=generator");

	private List<String> cantadas = List.of(
			"Acho que eu dormi na aula de História. Essa Deusa grega eu não conhecia.",
			"Se a Terra é redonda, por que não rola nada entre a gente?",
			"Quem diz que nada é perfeito, claramente nunca te viu sorrir.",
			"Sabe o que combina com esse dia lindo? Eu, do seu lado, segurando sua mão.",
			"Você não é previsão do tempo, mas sempre que te vejo, meu dia melhora.",
			"Quando eu te mandar bom dia amanhã, para qual número envio?",
			"Não penso em você 24 horas por dia... de 17h às 20h costumo pensar em nós...",
			"Você tem um mapa? Porque eu me perdi no seu sorriso.",
			"Teus olhos deviam ser poema… porque toda vez que eu encaro, eu perco a linha.",
			"Teus olhos têm um charme tão silencioso que dá vontade de pedir legenda.",
			"Tem sorriso que desarma… o seu me desmonta e ainda pergunta se tá tudo bem.",
			"Se isso aqui fosse um aviso, seria: ‘cuidado, você pode causar sorrisos involuntários.",
			"Tem detalhes seus que parecem escritos com tinta que não desbota.");

	
	public String gerarPagina() {
		String musica = getRandom(musicas);
		String cantada = getRandom(cantadas);

		return """
				<html lang="pt-br">

				<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>Cantada</title>

				<style>

					body {
							margin: 0;
				    		padding: 0;
				    		min-height: 100dvh;

				    		background:
				        	linear-gradient(0deg, rgba(0,0,0,0.03) 0%%, rgba(255,255,255,0.03) 100%%),
				        	linear-gradient(135deg, #faf2f4, #ffeef3);

				    		font-family: "Playfair Display", serif;
							);
					    }

					.texto {
					
							text-align: center;
							margin: 20px auto;
							padding: 10px;
							max-width: 90%%;
							
							}

					.iframe-wrapper {
					
							overflow: hidden;
							border-radius: 12px;
							max-width: 380px;
							width: 100%%;
							margin: auto;
								    
							}

					.iframe-wrapper iframe {
							width: 100%%;
							height: 352px;
							border-radius: 12px;
							border: none;
							overflow: hidden;
							}

					iframe::-webkit-scrollbar {
							display: none;
						    }
						    
					.loader {
							position: fixed;
							top: 0;
							left: 0;
							width: 100%%;
    						height: 100%%;
    						background: rgba(255, 240, 245, 0.9);
    						display: flex;
    						justify-content: center;
    						align-items: center;
    						font-family: "Georgia", serif;
    						font-size: 22px;
    						color: #5a3e4d;
    						backdrop-filter: blur(2px);
    						transition: opacity 0.4s ease;
    						z-index: 999;
							}

					.loader.hidden {
							opacity: 0;
							pointer-events: none;
							}

					</style>
					</head>

					<body>

					<h1 class="texto">%s</h1>
								
					<div id="loader" class="loader">
				  			Você me inspirou..
					</div>
								
					<div class="iframe-wrapper">
						   	<iframe src="%s" onload="document.getElementById('loader').classList.add('hidden')"
				           	allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
				        	loading="lazy"></iframe>
								</div>

					<footer style="text-align: center; margin-top: 25px; padding-bottom: 20px;">
				    		<a href="https://instagram.com/danilolima.0"
				       		target="_blank"
							style="font-family: 'Georgia', serif; font-size: 1rem; color: #b53a50; text-decoration: none;">
				       		Feito por Danilo 💌 — DaniloLima.0
				   			</a>
					</footer

					</body>
					</html>
								"""
				.formatted(cantada, musica);

	}
	
	
	@GetMapping(value = "/raissa", produces = "text/html")
	public String raissa(){
		return gerarPagina();
	}
	
	@GetMapping(value = "/eduarda", produces = "text/html")
	public String eduarda(){
		return gerarPagina();
	}
	
	@GetMapping(value = "/cantada", produces = "text/html")
	public String cantada() {
		return gerarPagina();
	}
	
	private String getRandom(List<String> lista) {
		return lista.get((int) (Math.random() * lista.size()));
	}

}
