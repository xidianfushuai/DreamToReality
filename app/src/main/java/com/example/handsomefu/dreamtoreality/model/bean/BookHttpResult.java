package com.example.handsomefu.dreamtoreality.model.bean;

/**
 * Created by HandsomeFu on 2016/11/17.
 *{"":1,
 * "":0,"
 * ":18839,
 * "books":[{"rating":{"max":10,"numRaters":112,"average":"9.4","min":0},"subtitle":"Impure Souls Anime Manga","author":["Dark Horse Comics"],"pubdate":"2006-1-3","tags":[{"count":22,"name":"漫画","title":"漫画"},{"count":16,"name":"hellsing","title":"hellsing"},{"count":13,"name":"平野耕太","title":"平野耕太"},{"count":11,"name":"吸血鬼","title":"吸血鬼"},{"count":8,"name":"日本漫画","title":"日本漫画"},{"count":6,"name":"日本","title":"日本"},{"count":4,"name":"惊惊","title":"惊惊"},{"count":3,"name":"值得再读","title":"值得再读"}],"origin_title":"","image":"https://img1.doubanio.com\/mpic\/s4515659.jpg","binding":"Paperback","translator":[],"catalog":"","pages":"160","images":{"small":"https://img1.doubanio.com\/spic\/s4515659.jpg","large":"https://img1.doubanio.com\/lpic\/s4515659.jpg","medium":"https://img1.doubanio.com\/mpic\/s4515659.jpg"},"alt":"https:\/\/book.douban.com\/subject\/1511257\/","id":"1511257","publisher":"Dark Horse Books\/Digital Manga Publishing","isbn10":"1593073933","isbn13":"9781593073930","title":"Hellsing","url":"https:\/\/api.douban.com\/v2\/book\/1511257","alt_title":"","author_intro":"","summary":"A secret war brews in the night - a war where humanity is only a pawn. The Hellsing Organization deploys in the shadows to protect the mortal world. But now, artificially spawned vampires have appeared, forcing Hellsing to call in their ultimate weapon - the rogue vampire, Alucard! We present \"Hellsing: Impure Souls Anime Manga\", adapted from the popular anime series, now in book form for your sustained joy and dread.","price":"USD 14.95"}]}
 */
public class BookHttpResult<T> {
    private int count;
    private int start;
    private int total;
    private T books;
    public T getResult() {
        return books;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
