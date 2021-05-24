package com.paradox.library.models.account;

import com.paradox.library.models.book.BookItem;
import com.paradox.library.models.enums.AccountStatus;

public class Librarian extends Account{
    public void addBookItem(BookItem bookItem) {

    }

    public void blockMember(Member member) {
        member.setStatus(AccountStatus.BLACKLISTED);
    }

    public void unBlockMember(Member member) {
        member.setStatus(AccountStatus.ACTIVE);
    }

    @Override
    public void resetPassword(String newPassword) {
        this.setPassword(newPassword);
    }
}
