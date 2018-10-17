package br.com.datamob.ads_avisoapp.data;

public class DataMensagem
{
    private IVString mensagem;
    private IVString autor;

    public IVString getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(IVString mensagem)
    {
        this.mensagem = mensagem;
    }

    public IVString getAutor()
    {
        return autor;
    }

    public void setAutor(IVString autor)
    {
        this.autor = autor;
    }
}
