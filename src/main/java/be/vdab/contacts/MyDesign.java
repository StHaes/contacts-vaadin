package be.vdab.contacts;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;


/**
 * Created by jeansmits on 8/07/15.
 */
@DesignRoot
public class MyDesign extends VerticalLayout {
    Button contactsButton;
    Button registrationButton;
    Button loginButton;
    Layout contentVerticalLayout;

    Label contentLabel;

    public MyDesign() {
        Design.read("StyleHtml.html", this);
    }

    public Button getContactsButton() {
        return contactsButton;
    }

    public Button getRegistrationButton() {
        return registrationButton;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Label getContentLabel() {
        return contentLabel;
    }

    public Layout getContentVerticalLayout() {
        return contentVerticalLayout;
    }
}


