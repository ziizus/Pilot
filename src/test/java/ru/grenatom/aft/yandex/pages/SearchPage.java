package ru.grenatom.aft.yandex.pages;

import ru.grenatom.aft.base.SuperPageFactory;

public class SearchPage extends SuperPageFactory {

    private SearchArrow searchArrow;

     public void search(String request) {
        searchArrow.search(request);
    }

    // Other methods here ...
}