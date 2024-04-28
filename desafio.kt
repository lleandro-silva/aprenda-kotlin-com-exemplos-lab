// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(
    val nome: String,
    val email: String,
    val idade: Int
)

data class ConteudoEducacional(
    var nome: String,
    val duracao: Int = 60,
    val descricao: String = ""
)

class Formacao(val nome: String, var conteudos: MutableList

    <ConteudoEducacional>) {

    val inscritos = mutableListOf

    <Usuario>()

    fun matricular(usuario: Usuario) {
        if (usuario !in inscritos) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado nesta formação.")
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Novo conteúdo '${conteudo.nome}' adicionado à formação $nome.")
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        if (conteudo in conteudos) {
            conteudos.remove(conteudo)
            println("Conteúdo '${conteudo.nome}' removido da formação $nome.")
        } else {
            println("Conteúdo '${conteudo.nome}' não encontrado na formação $nome.")
        }
    }

    fun verificarProgresso(usuario: Usuario): Double {
        // Simulação: retorna um progresso aleatório entre 0 e 100%
        return (0..100).random().toDouble()
    }

    fun calcularDuracaoTotal(): Int {
        return conteudos.sumBy { it.duracao }
    }

    fun notificarUsuariosNovoConteudo() {
        inscritos.forEach { usuario ->
            usuario.email.also { email ->
                // Simulação de envio de email
                println("Email enviado para $email: Novo conteúdo adicionado na formação $nome.")
            }
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Kotlin", 90, "Aprenda os conceitos básicos da linguagem Kotlin.")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120, "Aprofunde seus conhecimentos em Kotlin com POO.")
    
    val formacaoKotlin = Formacao("Formação Kotlin", mutableListOf(conteudo1, conteudo2))
    
    val usuario1 = Usuario("João", "joao@example.com", 25)
    val usuario2 = Usuario("Maria", "maria@example.com", 30)
    
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    
    formacaoKotlin.adicionarConteudo(ConteudoEducacional("Collections em Kotlin", 90, "Aprenda sobre listas, sets e maps em Kotlin."))
    formacaoKotlin.removerConteudo(conteudo1)
    
    println("Progresso do usuário ${usuario1.nome}: ${formacaoKotlin.verificarProgresso(usuario1)}%")
    
    println("Duração total da formação ${formacaoKotlin.nome}: ${formacaoKotlin.calcularDuracaoTotal()} minutos")
    
    formacaoKotlin.notificarUsuariosNovoConteudo()
}