package ru.otus.hw.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.utils.shell.comment.CommentShellUtilsProvider;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@ShellComponent
public class CommentShellCommander {
    private final CommentShellUtilsProvider provider;

    public CommentShellCommander(CommentShellUtilsProvider provider) {
        this.provider = provider;
    }

    @ShellMethod(key = {"cc", "ccom"}, value = "Create comment on book")
    public void createComment(Integer bookId) {
        provider.create(bookId);
    }

    @ShellMethod(key = {"cu", "cupd"}, value = "Update comment by id")
    public void updateComment(Integer id) {
        provider.update(id);
    }

    @ShellMethod(key = {"cd", "cdel"}, value = "Delete comment by id")
    public void deleteComment(Integer id) {
        provider.deleteById(id);
    }

    @ShellMethod(key = {"cb", "cl", "clist"}, value = "Browse all comments")
    public void listComments() {
        provider.browse();
    }

    @ShellMethod(key = {"cbb", "cbl", "cblist"}, value = "Browse comments on book")
    public void listCommentsOnBook(Integer bookId) {
        provider.browseByBookId(bookId);
    }
}
