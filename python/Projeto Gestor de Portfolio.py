import datetime
import json

def carregar_dados():
    try:
        with open ("portfolio.json", "r", encoding ="utf-8") as arquivo:
                projetos = json.load(arquivo)
                return projetos
    except FileNotFoundError:
        print("Não foi possível encontrar este portfólio salvo.")
        return []
    except json.JSONDecodeError:
        print("ERRO: o arquivo está vazio ou corrompido.")
        return []


def salvar_projetos(projetos):
    try:
        with open("portfolio.json", "w", encoding="utf-8") as arquivo:
            json.dump(projetos, arquivo, indent=4, ensure_ascii=False)
        print("Portfólio salvo com sucesso!")

    except OSError:
        print("ERRO: não foi possível salvar o portfólio.")


def mostrar_menu ():
    largura = 60

    print("\n" + "=" * largura)
    print("MEU GESTOR DE PORTFÓLIO PESSOAL".center(largura))
    print("Bem-vindo(a), Evanir!".center(largura))
    print("=" * largura)

    print(f"{'COMANDO':<10} | DESCRIÇÃO")
    print("-" * largura)
    print(f"{'ADD':<10} | Adicionar um novo projeto")
    print(f"{'LIST':<10} | Listar os projetos cadastrados")
    print(f"{'UPDATE':<10} | Atualizar um projeto")
    print(f"{'REMOVE':<10} | Remover um projeto")
    print(f"{'QUITT':<10} | Salvar e sair do programa")

    print("=" * largura)


def adicionar_projetos(projetos):
    try:
        quantidade_projetos= int(
            input('Informe quantos projetos gostaria de cadastrar?  '))
    except ValueError:
        print("ERRO: formato inválido. Digite um número inteiro.")
        return

    if quantidade_projetos <= 0:
        print("Quantidade de projetos inválida, tente novamente.")

    else:
        for i in range(quantidade_projetos):
            nome_projeto = str(input('digite o nome do projeto: '))
            cadastro_de_projetos =  {"Nome": nome_projeto, "concluido": False,"historico": []}
            projetos.append(cadastro_de_projetos)
            print(f"Parabéns, projeto {nome_projeto} cadastrado com sucesso!!")

def listar_projetos(projetos):
    if len(projetos) <= 0:
        print("Que pena... Não há projetos a serem exibidos no momento.")
    else:
        for projeto in projetos:
            print("Detalhes do Projeto:")
            for chave, valor in projeto.items():
                print(f"{chave} : {valor}")


def atualizar_projeto (projetos):
    projeto_para_modificar = str(input('Qual o projeto deseja modificar? '))

    for projeto in projetos:
        if projeto["Nome"].upper() == projeto_para_modificar.upper():
            nome_antigo = projeto["Nome"]

            novo_nome = input("Digite o novo nome do projeto: ")

            try:
                status = int(input("O projeto está finalizado? Digite '1' para sim e '0'para não. "))
            except ValueError:
                print("ERRO: formato inválido. Digite apenas 1 ou 0.")
                return

            if status != 0 and status != 1:
                print("ERRO: digite apenas 1 ou 0.")
                return
            projeto["Nome"] = novo_nome
            projeto["concluido"] = bool(status)

            data_alteracao = datetime.datetime.now().strftime("%d/%m/%Y às %H:%M:%S")

            entrada_atualizacao = (
                data_alteracao,
                 f"Nome alterado de: '{nome_antigo}' para '{novo_nome}'," f"Concluído: {projeto['concluido']}")
            projeto["historico"].append(entrada_atualizacao)
            print("Projeto atualizado com sucesso!")
            break
    else:
         print ("Projeto não  localizado")


def pesquisar_projeto(nome_pesquisado, lista_projetos):
    for projeto in lista_projetos:
        if projeto["Nome"].upper() == nome_pesquisado.upper():
            return projeto
    return None


def remover_projeto(projetos):
    projeto_para_remover = str(input('Qual projeto deseja remover? '))
    if len(projetos) >0:
        retorno_find = pesquisar_projeto(projeto_para_remover, projetos)
        if retorno_find is not None:
            projetos.remove(retorno_find)
            print("Projeto removido com sucesso!")
        else:
            print(f"Desculpe, o projeto '{projeto_para_remover}' não foi encontrado. ")
    else:
        print("Não há projetos cadastrados para remover")



projetos = carregar_dados()
mostrar_menu()
while True:
    comando = input('Digite um comando:  ').upper()
    if comando == "QUITT":
        salvar_projetos(projetos)
        print("Encerrando o programa")
        break
    elif comando == "ADD":
        adicionar_projetos(projetos)
    elif comando == "LIST":
        listar_projetos(projetos)
    elif comando == "REMOVE":
        remover_projeto(projetos)
    elif comando == "UPDATE":
        atualizar_projeto(projetos)
    else:
        print("Ops, comando inválido, tente novamente")
print ("Até logo!")




