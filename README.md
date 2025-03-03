

# Gerenciamento de Tráfego
- **Descrição:**
  - Controle de semáforos inteligentes baseado em fluxo de tráfego e condições climáticas.
  - Monitoramento e análise de padrões de tráfego para otimização de rotas e redução de congestionamentos.
  - Detecção e notificação automática de acidentes de trânsito para serviços de emergência.

- **Sobre o Projeto:**
  O projeto é um sistema Spring Boot desenvolvido para gerenciar informações de tráfego relacionadas a veículos, câmeras de monitoramento e usuários administrativos, conectando-se a um banco de dados Oracle. Ele contém funcionalidades de cadastro, listagem, atualização e exclusão de dados, com autenticação e autorização implementadas para garantir segurança nas operações.

---

## Principais Funcionalidades e Estrutura

### Autenticação e Autorização:
- O sistema utiliza autenticação via tokens JWT, com rotas controladas por perfis de acesso definidos (ADMIN e USER).
- O `AuthCentralController` lida com o registro e login dos usuários administrativos (centrais de monitoramento).

### Gerenciamento de Câmeras e Veículos:
- O sistema permite inserir, listar, atualizar e deletar informações de câmeras de monitoramento e veículos, como registrado em `CameraController` e `VeiculoController`.
- Cada controlador é acompanhado de um serviço (`CameraService`, `VeiculoService`) que centraliza a lógica de negócios, garantindo modularidade e coesão.

### Configurações de Segurança:
- O `SecurityConfig` define rotas protegidas por perfis de acesso, garantindo que apenas usuários autorizados realizem operações sensíveis.
- O sistema aplica o uso do `BCryptPasswordEncoder` para armazenar senhas de forma segura.

### Modelo de Dados:
- Classes de modelo como `Camera`, `Veiculo` e `Central` são mapeadas para tabelas no banco de dados, utilizando anotações JPA.
- A entidade `Central` implementa `UserDetails`, permitindo a integração com o Spring Security e uma abordagem flexível para gestão de usuários e permissões.

### Configuração do Banco de Dados:
- O sistema está configurado para um banco de dados Oracle, com migrações de banco automatizadas pela ferramenta Flyway, facilitando a manutenção e controle de versão dos dados.

---

## Vantagens do Projeto

### Segurança Robusta:
- A integração com Spring Security e JWT oferece um sistema de autenticação e autorização seguro, essencial para sistemas de monitoramento de dados sensíveis.

### Estrutura Modular:
- A separação clara entre controllers, serviços e modelos promove um design orientado a objetos de fácil manutenção e escalabilidade.

### Fácil Integração com Banco de Dados:
- A configuração com Flyway e a utilização de JPA simplificam o gerenciamento e a migração do banco de dados, facilitando futuras atualizações.

### Flexibilidade e Controle:
- O uso de perfis de acesso e a configuração de rotas específicas permitem um controle refinado sobre quem pode acessar e modificar cada recurso, essencial em cenários de monitoramento.

---

## Conclusão
Esse sistema é altamente estruturado para ser escalável e seguro, com uma arquitetura orientada a microserviços que facilita a modularidade e a manutenção, além de ser facilmente adaptável para novas funcionalidades.
