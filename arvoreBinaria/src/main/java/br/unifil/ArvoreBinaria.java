package br.unifil;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void inserir(int conteudo) {
        No novoNo = new No(conteudo);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;
            while (atual != null) {
                if (novoNo.getConteudo() < atual.getConteudo()) {
                    pai = atual;
                    atual = atual.getNoEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getNoDir();
                    esquerda = false;
                }
            }

            if (esquerda) {
                pai.setNoEsq(novoNo);
            } else {
                pai.setNoDir(novoNo);
            }
        }
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.print(no.getConteudo() + " ");
        preOrdem(no.getNoEsq());
        preOrdem(no.getNoDir());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getNoEsq());
        System.out.print(no.getConteudo() + " ");
        emOrdem(no.getNoDir());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getNoEsq());
        posOrdem(no.getNoDir());
        System.out.print(no.getConteudo() + " ");
    }

    public void remover(int conteudo) {
        No atual = this.raiz;
        No pai = null;
        No filho = null;
        No temporario = null;

        // Para localizar o nó que será removido
        while(atual != null && atual.getConteudo() != conteudo) {
            pai = atual;

            if(conteudo < atual.getConteudo()) {
                atual = atual.getNoEsq();
            } else {
                atual = atual.getNoDir();
            }
        }

        // Se o nó a ser removido não for encontrado, ele não consta na árvore
        if(atual == null) {
            System.out.println("Não encontrado!");
            return;
        }

        // Se o nó a ser removido for a raiz
        if(pai == null) {
            if(atual.getNoDir() == null) {
                this.raiz = atual.getNoEsq();
            } else if(atual.getNoEsq() == null) {
                this.raiz = atual.getNoDir();
            } else {
                temporario = atual;
                filho = atual.getNoDir();

                // Percorre até encontrar o nó mais à esquerda
                while(filho.getNoEsq() != null) {
                    temporario = filho;
                    filho = filho.getNoEsq();
                }

                // Se o último nó sem filhos à esquerda for diferente do primeiro nó que sucede a raiz
                if(filho != atual.getNoDir()) {
                    // Tudo que estiver à direita do filho passará para o nó temporário
                    temporario.setNoEsq(filho.getNoDir());
                    // O filho (que é o menor nó à esquerda) apontará para o nó à direita daquele que foi removido
                    filho.setNoDir(atual.getNoDir());
                }

                // O nó à esquerda do nó removido é anexado ao nó filho (que é a nova raiz)
                filho.setNoEsq(atual.getNoEsq());
                this.raiz = filho;
            }
        } else {
            // Se for um nó sem filhos, basta substituir por nulo
            if(atual.getNoDir() == null && atual.getNoEsq() == null) {
                if(pai.getNoEsq() == atual) {
                    pai.setNoEsq(null);
                } else {
                    pai.setNoDir(null);
                }
            }
            // Nó com um filho à esquerda
            else if(atual.getNoDir() == null) {
                // Verifica se o nó a ser removido está à esquerda ou à direita do pai
                if(pai.getNoEsq() == atual) {
                    pai.setNoEsq(atual.getNoEsq());
                } else {
                    pai.setNoDir(atual.getNoEsq());
                }
            }
            // Nó com um filho à direita
            else if(atual.getNoEsq() == null) {
                // Verifica se o nó a ser removido está à esquerda ou à direita do pai
                if(pai.getNoEsq() == atual) {
                    pai.setNoEsq(atual.getNoDir());
                } else {
                    pai.setNoDir(atual.getNoDir());
                }
            }
            // Nó com dois filhos
            else {
                temporario = atual;
                filho = atual.getNoDir();

                // Percorre até encontrar o nó mais à esquerda
                while(filho.getNoEsq() != null) {
                    temporario = filho;
                    filho = filho.getNoEsq();
                }

                if(filho != atual.getNoDir()) {
                    // Tudo que estiver à direita do filho passará para o nó temporário
                    temporario.setNoEsq(filho.getNoDir());
                    // O filho (que é o menor nó à esquerda) apontará para o nó à direita daquele que foi removido
                    filho.setNoDir(atual.getNoDir());
                }

                // O nó à esquerda do nó removido é anexado ao nó filho (que é a nova raiz da subárvore)
                filho.setNoEsq(atual.getNoEsq());

                // Puxa o apontamento do pai para a nova raiz da subárvore
                if(pai.getNoEsq() == atual) {
                    pai.setNoEsq(filho);
                } else {
                    pai.setNoDir(filho);
                }
            }
        }
    }
}