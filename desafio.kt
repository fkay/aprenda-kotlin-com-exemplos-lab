// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
// [Template modificado no Kotlin Playground](https://pl.kotl.in/gnrGrO7HQ)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun detalhesFormacao() {
        println("$nome")
        for(conteudo in conteudos){
            with(conteudo) {
            	println("$nome - duração: $duracao - Nível: $nivel")
            }
        }
    }
    
    fun matricular(usuario: Usuario) {
        // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
        println("Usuário: ${usuario.nome} inscrito com sucesso!")
    }
    
    fun listarUsuarios() {
        if(inscritos.size == 0) {
        	println("Sem usuários inscritos")
            return
        }
        println("Usuários inscritos: ")
        for(usuario in inscritos) {
            println("${usuario.nome}")
        }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("José")
    
    val conteudos = mutableListOf<ConteudoEducacional>()
    conteudos.add(ConteudoEducacional("Introdução a Linguagem", 30))
    conteudos.add(ConteudoEducacional("Funções e controle de fluxo", 40, Nivel.INTERMEDIARIO))
    conteudos.add(ConteudoEducacional("Tratamento de Exceções", 20, Nivel.AVANCADO))
        
    val formacao = Formacao("Linguagem Kotlin", conteudos)
    formacao.detalhesFormacao()
    
    formacao.listarUsuarios()
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    
    formacao.listarUsuarios()
}