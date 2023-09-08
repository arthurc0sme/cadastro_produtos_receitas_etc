package trabGB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.io.FileReader;


public class mainTrabalho {

	public static void main(String[] args) throws InterruptedException {
			// Criação de uma variável file para checar se já existe um cadastro de mercado criado anteriormente, caso seja verdade, é pulado o menu de cadastro.
			File file = new File("CadastroMercado.txt");
	        boolean arquivoExistente = file.exists();
	        
			// Criação de um mercado vazio para ser preenchido no primeiro menu do programa.
			String nomeMercado = null;
			double valorCaixa = 0;
			
			// Criação do primeiro menu, antes do Gerente fazer seu cadastro com seus dados.
			boolean menu = true;
			boolean menu2 = false;
			boolean cadastro = false;
			int options;
			Scanner scan = new Scanner(System.in);
			int opcao;
			
			if (arquivoExistente) {
		            // Se o arquivo existir, pula diretamente para o segundo menu.
		            menu = false;
		            cadastro = true;
		        }
			
			while (menu) {
					//Opcao para realizar cadastro do mercado
				System.out.println("\n============= CARREGANDO MENU ==============");
				Thread.sleep(3000);
				System.out.println("\n============= MENU DE CADASTRO =============");
				System.out.println("\nDigite 1 -  Realizar cadastro:");
				System.out.println("\nDigite 9 - Sair:");
				System.out.println("\n=======================================================");
				opcao = scan.nextInt();
				switch (opcao) {
					//Opcao para realizar cadastro do mercado
					case 1:
						System.out.println("Nome do Mercado:");
						scan.nextLine();
						nomeMercado = scan.nextLine();
						System.out.println("Valor em caixa atual R$: ");
						valorCaixa = scan.nextDouble();
						if (valorCaixa < 0) {
							System.out.println("Valor inválido!");
							break;
						}
						Thread.sleep(1000);
						System.out.println("\n============= CADASTRO REALIZADO =============");
						Thread.sleep(1000);
						System.out.println("\n Nome Mercado: " + nomeMercado); 
						System.out.println("\n Valor em Caixa: R$" + valorCaixa); 
						System.out.println("\n==============================================");
						Thread.sleep(3000);
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter("CadastroMercado.txt"));
							writer.write("======================DADOS=====================");
							writer.newLine();
				            String linha ="\nNome do Mercado: " + nomeMercado + "\nValor em caixa: " + valorCaixa;
				            writer.write(linha);
				            writer.newLine();
				            writer.close();
						} catch (IOException e) {
				            System.out.println("Erro ao salvar arquivo com dados do mercado: " + e.getMessage());
				        }
						cadastro = true;
						menu = false;
						break;

					//Opção de Saída do programa pelo menu 1.
					case 9:
						menu = false;
						System.out.println("Você saiu do programa!");
						break;

					// Caso o gerente informe um valor de entrada inválido no menu 1.
					default:
						System.out.println("Valor inválido");
				}

			}

			
			if (cadastro == true) {
				menu2 = true;
				//Caso ja exista um cadastro, o menu 2 será mostrado diretamente.
				if (arquivoExistente) {
					System.out.println("\n============== CADASTRO ANTERIOR IDENTIFICADO ==============");
					// Ler os dados de cadastro existente e recupera os valores NomeMercado e ValorCaixa para ser possível subtrair e somar valores de fluxo de caixa.
			        try {
			            BufferedReader reader = new BufferedReader(new FileReader("CadastroMercado.txt"));
			            String linha;
			            while ((linha = reader.readLine()) != null) {
			                if (linha.startsWith("Nome do Mercado:")) {
			                     nomeMercado = linha.substring("Nome do Mercado: ".length());
			                } else if (linha.startsWith("Valor em caixa:")) {
			                     valorCaixa = Double.parseDouble(linha.substring("Valor em caixa: ".length()));
			                    }
			                }
			            
			            reader.close();
			        } catch (IOException e) {
			        	System.out.println("Ocorreu um erro ao carregar dados: " + e.getMessage());
			        }
			        System.out.println("Nome do Mercado: " + nomeMercado);
			        System.out.println("Valor em caixa atual: R$" + valorCaixa);
				}
				//Caso não exista um cadastro, todos os arquivos serão limpos se existentes, e se não existirem serão criados vazios.
				if(!arquivoExistente) {
					try {
                        FileWriter writer = new FileWriter("CadastroClientes.txt");
                        writer.write(""); 
                        writer.close();
                        FileWriter writer2 = new FileWriter("CadastroProdutos.txt");
                        writer2.write(""); 
                        writer2.close();
                        FileWriter writer3 = new FileWriter("Despesas.txt");
                        writer3.write(""); 
                        writer3.close();
                        FileWriter writer4 = new FileWriter("Receitas.txt");
                        writer4.write(""); 
                        writer4.close();
                        FileWriter writer5 = new FileWriter("Vendas.txt");
                        writer5.write(""); 
                        writer5.close();
                        System.out.println("Arquivos anteriores limpos com sucesso.");
                    }catch (IOException e) {
                        System.out.println("Ocorreu um erro ao limpar dados: " + e.getMessage());
                    }
				}
				
				while (menu2) {
					//Segundo menu, para realizar as operações do programa
					System.out.println("\n============== CARREGANDO DADOS ==============");
					Thread.sleep(3000);
					System.out.println("\nDigite 1  para cadastrar clientes: ");
					System.out.println("\nDigite 2  para cadastrar produtos: ");
					System.out.println("\nDigite 3  para informar receitas: ");
					System.out.println("\nDigite 4  para informar despesas: ");
					System.out.println("\nDigite 5  para informar vendas: ");
					System.out.println("\nDigite 6  para deletar dados: ");
					System.out.println("\nDigite 7  para ler dados: ");
					System.out.println("\nDigite 9  para salvar dados e sair do programa:");
					System.out.println("\n==============================================");
					
					opcao = scan.nextInt();
					scan.nextLine();
					switch (opcao) {
						//Opção 1, cadastro de clientes
						case 1:
							options = 1;
							boolean cadastroCliente = true;
							List<cliente> clientes = new ArrayList<>();
							while (cadastroCliente == true) {
								//Cadastro do Cliente
								System.out.println("Nome do Cliente: ");
								String nome = scan.nextLine();
								System.out.println("CPF: ");
								String cpf = scan.nextLine();
								System.out.println("Endereço: ");
								String endereco = scan.nextLine();
								cliente cliente = new cliente(nome, cpf, endereco);
								clientes.add(cliente);
								//Passando para o arquivo os dados do cliente
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CadastroClientes.txt", true));
						            String linha ="\nNome do Cliente: " + nome + "\nCPF: " + cpf + "\nEndereço: " + endereco;
						            writer.write(linha);
						            writer.newLine();
						            writer.close();
						            System.out.println("Cliente gravado para o arquivo de texto com sucesso!");
								} catch (IOException e) {
						            System.out.println("Erro ao transferir as pessoas para o arquivo de texto: " + e.getMessage());
						        }
								System.out.println("Cadastrar mais cliente? ");
								System.out.println("0 - Não");
								System.out.println("1 - Sim");
								options = scan.nextInt();
								
								if (options == 1) {
									scan.nextLine();
									continue;
								}
								else if (options == 0) {
									cadastroCliente = false;
						
								}
								if (cadastroCliente == false) {
									System.out.println("Cadastro encerrado!");
									break;
								}
							}
							break;
			
						case 2: 
							options = 1;
							boolean cadastroProduto = true;
							List<produto> produtos = new ArrayList<>();
							while (cadastroProduto == true) {
								//Cadastro do Produto
								System.out.println("Nome do Produto: ");
								String nome = scan.nextLine();
								System.out.println("Descricao: ");
								String descricao = scan.nextLine();
								System.out.println("Quantidade: ");
								int quantidade = scan.nextInt();
								System.out.println("Valor da Unidade em R$: ");
								double valor = scan.nextDouble();
								produto produto = new produto(nome, descricao, quantidade, valor);
								produtos.add(produto);
								//Passando para o arquivo os dados do produto
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CadastroProdutos.txt", true));
						            String linha ="\nNome do Produto: " + nome + "\nDescricao: " + descricao + "\nQuantidade: " + quantidade + "\nValor da Unidade: R$" + valor;
						            writer.write(linha);
						            writer.newLine();
						            writer.close();
						            System.out.println("Produto gravado para o arquivo de texto com sucesso!");
								} catch (IOException e) {
						        	//Mensagem de erro para 
						            System.out.println("Erro ao transferir os produtos para o arquivo de texto: " + e.getMessage());
						        }
								
								System.out.println("Cadastrar mais produtos? ");
								System.out.println("0 - Não");
								System.out.println("1 - Sim");
								options = scan.nextInt();
								
								if (options == 1) {
									scan.nextLine();
									continue;
								}
								else if (options == 0) {
									cadastroProduto = false;
								}
								else if (options > 1) { 
									System.out.println("ENTRADA INVÁLIDA! ");
									break;
								}
								if (cadastroProduto == false) {
									System.out.println("Cadastro de produtos encerrado!");
									break;
								}
								break;
							}
							break;

						case 3:
							boolean entradaReceitas = true;
							List<receitas> receita = new ArrayList<>();
							while (entradaReceitas == true) {
								//Inserção das receitas/serviçoes
								System.out.println("Descreva a receita/serviço: ");
								String descricao = scan.nextLine();
								System.out.println("Data: ");
								String data = scan.nextLine();
								System.out.println("Valor em R$: ");
								Double valor = scan.nextDouble();
								valorCaixa = valorCaixa + valor;
								receitas entradaReceita = new receitas(descricao, data, valor);
								receita.add(entradaReceita);
								//Passando para o arquivo os dados de receita/serviço
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("Receitas.txt", true));
						            String linha ="\nDescrição da receita/serviço: " + descricao + "\nData: " + data + "\nValor: R$" + valor;
						            writer.write(linha);
						            writer.newLine();
						            writer.close();
						            System.out.println("Gravado para o arquivo de texto com sucesso!");
						            System.out.println("Novo valor em caixa: R$" + valorCaixa);
						            
								} catch (IOException e) {
						        	//Mensagem de erro 
						            System.out.println("Erro ao transferir receita/serviço para o arquivo de texto: " + e.getMessage());
						        }
								//Atualizando dados do mercado com o novo valor de caixa
			                	try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CadastroMercado.txt"));
									writer.write("======================DADOS=====================");
									writer.newLine();
						            String linha ="\nNome do Mercado: " + nomeMercado + "\nValor em caixa: " + valorCaixa;
						            writer.write(linha);
						            writer.newLine();
						            writer.close();
								} catch (IOException e) {
						            System.out.println("Erro ao salvar arquivo com dados do mercado: " + e.getMessage());
						        }
								System.out.println("Inserir mais receitas/serviços prestados? ");
								System.out.println("0 - Não");
								System.out.println("1 - Sim");
								options = scan.nextInt();
								scan.nextLine();
								if (options == 1) {
									continue;
								}
								else if (options == 0) {
									entradaReceitas = false;
						
								}
								else if (options > 1) { 
									System.out.println("ENTRADA INVÁLIDA! ");
									break;
								}
								if (entradaReceitas == false) {
									System.out.println("Inserção de receitas (serviços) encerrado!");
									break;
								}
							}
							
							break;
						case 4:
							boolean entradaDespesa = true;
							List<despesa> listadespesas = new ArrayList<>();
							while (entradaDespesa == true) {
								//Inserção das despesas
			                    System.out.println("Descrição da despesa: ");
			                    String descricao = scan.nextLine();
			                    System.out.println("Data: ");
			                    String data = scan.nextLine();
			                    System.out.println("Valor em R$: ");
			                    double valor = scan.nextDouble();
			                    valorCaixa = valorCaixa - valor;
			                    scan.nextLine();
			                    despesa despesas = new despesa(descricao, data, valor);
			                	listadespesas.add(despesas);
			                    // Código para salvar a despesa no arquivo de texto
			                	try {
			                        FileWriter writer = new FileWriter("Despesas.txt", true); // Abre o arquivo para escrita (true para modo append)
			                        String linha ="\nDescrição: " + descricao + "\nData: " + data + "\nValor: R$" + valor;
			                        writer.write(linha);
			                        writer.write("\n"); // Pula para a próxima linha
			                        writer.close(); // Fecha o arquivo
			                        System.out.println("Arquivo salvo com sucesso!");
			                        System.out.println("Novo valor em caixa: R$" + valorCaixa);
			                    } catch (IOException e) {
			                        System.out.println("Erro ao salvar: " + e.getMessage());
			                    }
			                	//Atualizando dados do mercado com o novo valor de caixa
			                	try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CadastroMercado.txt"));
									writer.write("======================DADOS=====================");
									writer.newLine();
						            String linha ="\nNome do Mercado: " + nomeMercado + "\nValor em caixa: " + valorCaixa;
						            writer.write(linha);
						            writer.newLine();
						            writer.close();
								} catch (IOException e) {
						            System.out.println("Erro ao salvar arquivo com dados do mercado: " + e.getMessage());
						        }
			                    System.out.println("Despesa cadastrada com sucesso!");
			                    System.out.println("Inserir mais despesas? ");
								System.out.println("0 - Não");
								System.out.println("1 - Sim");
								options = scan.nextInt();
								scan.nextLine();
								if (options == 1) {
									continue;
								}
								
								else if (options == 0) {
									entradaDespesa = false;
						
								}
								else if (options > 1) { 
									System.out.println("ENTRADA INVÁLIDA! ");
									break;
								}
								if (entradaDespesa == false) {
									System.out.println("Inserção de receitas (serviços) encerrado!");
									break;
								}
							}
		                    break;
						case 5:
							options = 1;
							boolean cadastroVenda = true;
							List<venda> vendas = new ArrayList<>();
							while (cadastroVenda == true) {
								//Inserção das vendas
								System.out.println("Descrição da Venda: ");
								String descricao = scan.nextLine();
								System.out.println("Data: ");
								String data = scan.nextLine();
								System.out.println("Valor em R$: ");
								double valor = scan.nextDouble();
								valorCaixa = valorCaixa + valor;
								venda venda = new venda(descricao, data, valor);
								vendas.add(venda);
								// Código para salvar as vendas no arquivo de texto
								try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("Receitas.txt", true));
						            String linha ="\nDescrição da Venda: " + descricao + "\nData: " + data + "\nValor : R$" + valor;
						            writer.write(linha);
						            writer.newLine();
						            writer.close();
						            System.out.println("Venda gravada com sucesso!");
						            System.out.println("Novo valor em caixa: R$" + valorCaixa);
								} catch (IOException e) {
						        	//Mensagem de erro para 
						            System.out.println("Erro ao transferir as informações da venda para o arquivo de texto: " + e.getMessage());
						        }
								//Atualizando dados do mercado com o novo valor de caixa
			                	try {
									BufferedWriter writer = new BufferedWriter(new FileWriter("CadastroMercado.txt"));
									writer.write("======================DADOS=====================");
									writer.newLine();
						            String linha ="\nNome do Mercado: " + nomeMercado + "\nValor em caixa: " + valorCaixa;
						            writer.write(linha);
						            writer.newLine();
						            writer.close();
								} catch (IOException e) {
						            System.out.println("Erro ao salvar arquivo com dados do mercado: " + e.getMessage());
						        }
								scan.nextLine();
								System.out.println("Cadastrar mais alguma Venda? ");
								System.out.println("0 - Não");
								System.out.println("1 - Sim");
								options = scan.nextInt();
								scan.nextLine();
								
								if (options == 1) {
									continue;
								}
								
								else if (options == 0) {
									cadastroVenda = false;
								}
								else if (options > 1) { 
									System.out.println("ENTRADA INVÁLIDA! ");
									break;
								}
								if (cadastroVenda == false) {
									System.out.println("Cadastro de Vendas encerrado!");
									break;
								}
							}
							break;
						case 6:
							boolean sair = false;
							options = 1;
							while (!sair) {
								//Menu para o usuário escolher o que deseja deletar.
								System.out.println("Escolha o que deseja deletar:");
					            System.out.println("1 - Dados de Clientes");
					            System.out.println("2 - Dados de Produtos");
					            System.out.println("3 - Dados de Receitas");
					            System.out.println("4 - Dados de Despesas");
					            System.out.println("5 - Dados de Vendas");
					            System.out.println("6 - Deletar Cadastro e sair do programa");
					            System.out.println("9 - Sair");
					            
					            options = scan.nextInt();
					            switch (options) {
				                case 1:
				                	//Limpando o arquivo de clientes
				                	try {
				                        FileWriter writer = new FileWriter("CadastroClientes.txt");
				                        writer.write(""); 
				                        writer.close();
				                        System.out.println("Arquivo de clientes limpo com sucesso.");
				                    }catch (IOException e) {
				                        System.out.println("Ocorreu um erro ao limpar o arquivo: " + e.getMessage());
				                    }
				                	System.out.println("Deletar mais dados? ");
									System.out.println("0 - Não");
									System.out.println("1 - Sim");
									options = scan.nextInt();
									
									if (options == 1) {
										scan.nextLine();
										continue;
									}
									else if (options == 0) {
										break;
							
									}
									else if (options > 1) { 
										System.out.println("ENTRADA INVÁLIDA! ");
										break;
									}
				                case 2:
				                	try {
				                		//Limpando o arquivo de produtos
				                        FileWriter writer = new FileWriter("CadastroProdutos.txt");
				                        writer.write(""); 
				                        writer.close();
				                        System.out.println("Arquivo de produtos limpo com sucesso.");
				                    }catch (IOException e) {
				                        System.out.println("Ocorreu um erro ao limpar o arquivo: " + e.getMessage());
				                    }
				                	System.out.println("Deletar mais dados? ");
									System.out.println("0 - Não");
									System.out.println("1 - Sim");
									options = scan.nextInt();
									
									if (options == 1) {
										scan.nextLine();
										continue;
									}
									else if (options == 0) {
										break;
							
									}
									else if (options > 1) { 
										System.out.println("ENTRADA INVÁLIDA! ");
										break;
									}
				                    break;
				                    
				                case 3:
				                	try {
				                		//Limpando o arquivo de Receitas
				                        FileWriter writer = new FileWriter("Receitas.txt");
				                        writer.write(""); 
				                        writer.close();
				                        System.out.println("Arquivo de clientes limpo com sucesso.");
				                    }catch (IOException e) {
				                        System.out.println("Ocorreu um erro ao limpar o arquivo: " + e.getMessage());
				                    }
				                	System.out.println("Deletar mais dados? ");
									System.out.println("0 - Não");
									System.out.println("1 - Sim");
									options = scan.nextInt();
									
									if (options == 1) {
										scan.nextLine();
										continue;
									}
									else if (options == 0) {
										break;
							
									}
									else if (options > 1) { 
										System.out.println("ENTRADA INVÁLIDA! ");
										break;
									}
				                    break;
				                    
				                case 4:
				                	try {
				                		//Limpando o arquivo de Despesas
				                        FileWriter writer = new FileWriter("Despesas.txt");
				                        writer.write(""); 
				                        writer.close();
				                        System.out.println("Arquivo de clientes limpo com sucesso.");
				                    }catch (IOException e) {
				                        System.out.println("Ocorreu um erro ao limpar o arquivo: " + e.getMessage());
				                    }
				                	System.out.println("Deletar mais dados? ");
									System.out.println("0 - Não");
									System.out.println("1 - Sim");
									options = scan.nextInt();
									
									if (options == 1) {
										scan.nextLine();
										continue;
									}
									else if (options == 0) {
										break;
							
									}
									else if (options > 1) { 
										System.out.println("ENTRADA INVÁLIDA! ");
										break;
									}
				                    break;    
				                    
				                case 5:
				                	try {
				                		//Limpando o arquivo de vendas
				                        FileWriter writer = new FileWriter("Vendas.txt");
				                        writer.write(""); 
				                        writer.close();
				                        System.out.println("Arquivo de clientes limpo com sucesso.");
				                    }catch (IOException e) {
				                        System.out.println("Ocorreu um erro ao limpar o arquivo: " + e.getMessage());
				                    }
				                	System.out.println("Deletar mais dados? ");
									System.out.println("0 - Não");
									System.out.println("1 - Sim");
									options = scan.nextInt();
									
									if (options == 1) {
										scan.nextLine();
										continue;
									}
									else if (options == 0) {
										break;
									}
									else if (options > 1) { 
										System.out.println("ENTRADA INVÁLIDA! ");
										break;
									}
				                    break; 
				                case 6:
				                	//Opção de deletar cadastro, deleta o cadastro, os arquivos, e sai do programa.
				                	if (file.exists()) {
				                        // Deleta o arquivo cadastromercado.txt
				                        boolean deletado = file.delete();
				                        if (deletado) {
				                        	//Caso o arquivo tenha sido deletado, todos os arquivos do cadastro anterior serão limpos.
				                        	try {
				                                FileWriter writer = new FileWriter("CadastroClientes.txt");
				                                writer.write(""); 
				                                writer.close();
				                                FileWriter writer2 = new FileWriter("CadastroProdutos.txt");
				                                writer2.write(""); 
				                                writer2.close();
				                                FileWriter writer3 = new FileWriter("Despesas.txt");
				                                writer3.write(""); 
				                                writer3.close();
				                                FileWriter writer4 = new FileWriter("Receitas.txt");
				                                writer4.write(""); 
				                                writer4.close();
				                                FileWriter writer5 = new FileWriter("Vendas.txt");
				                                writer5.write(""); 
				                                writer5.close();
				                            }catch (IOException e) {
				                                System.out.println("Ocorreu um erro ao limpar dados: " + e.getMessage());
				                            }
				                            System.out.println("Cadastro deletado e programa encerrado com sucesso.");
				                        } else {
				                            System.out.println("Falha ao deletar o cadastro.");
				                        }
				                    } else {
				                        System.out.println("O arquivo não existe.");
				                    }
				                	//Comando para encerrar programa
				                	System.exit(0);
				                	break;
				                case 9:
				                	//Opção para sair do menu de deletar dados.
				                    sair = true;
				                    break;
				                    
				                default:
				                    System.out.println("Opção inválida");
				                    break;
					            }
							break;
							}
						case 7:
							//Agrupamento de todos os txt em um array, para ler e imprimir na tela o conteúdo de todos os arquivos.
							List<String> arquivos = new ArrayList<>();
							arquivos.add("CadastroMercado.txt");
					        arquivos.add("CadastroClientes.txt");
					        arquivos.add("CadastroProdutos.txt");
					        arquivos.add("Receitas.txt");
					        arquivos.add("Despesas.txt");
					        arquivos.add("Vendas.txt");

					        for (String arquivo : arquivos) {
					            try {
					                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
					                String linha;
					                while ((linha = reader.readLine()) != null) {
					                	Thread.sleep(0500);
					                    System.out.println(linha);
					                }
					                reader.close();
					            } catch (IOException e) {
					                System.out.println("Erro ao listar o arquivo " + arquivo + ": " + e.getMessage());
					            }
					        }
		                    break;
						case 8:
							break;
						// Opção para salvar dados e sair do programa pelo menu 2.
						case 9:
							menu2 = false;
							 	// Salvando todos os arquivos txt gerado pelo programa em um único arquivo.
						       String[] inputFiles = {"CadastroMercado.txt", "CadastroClientes.txt", "CadastroProdutos.txt", 
						    		   "Despesas.txt", "Receitas.txt"};
						     
						       
						       // Nome do arquivo de saída
						       String outputFile = "Relatorio.txt";
						       try {
						           BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
						           for (String inputFile : inputFiles) {
						               BufferedReader reader = new BufferedReader(new FileReader(inputFile));
						               String line;
						               while ((line = reader.readLine()) != null) {
						                   writer.write(line);
						                   writer.newLine();
						               }
						               reader.close();
						           }
						           
						           writer.close();
						           System.out.println("Dados salvos com sucesso! (O nome do arquivo é Relatorio.txt)");
						       } catch (IOException e) {
						           e.printStackTrace();
						       }
							
							System.out.println("Você saiu do programa!");
							break;
						// Opção caso o usuário informe algum valor inválido no menu 2.
						default:
							System.out.println("Valor inválido");
					}
				}
			}
			// Fechando a função Scanner
			scan.close();	
		}
	}
	// Fim do programa.

	