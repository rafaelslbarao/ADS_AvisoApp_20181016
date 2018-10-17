package br.com.datamob.ads_avisoapp.data;

import java.util.List;

public class Mensagens
{
    private Long total;
    private List<ItemMensagem> items;

    public Long getTotal()
    {
        return total;
    }

    public void setTotal(Long total)
    {
        this.total = total;
    }

    public List<ItemMensagem> getItems()
    {
        return items;
    }

    public void setItems(List<ItemMensagem> items)
    {
        this.items = items;
    }
}
