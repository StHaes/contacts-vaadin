package be.vdab.contacts;

import Person.Contact;
import Person.Gender;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import javax.servlet.annotation.WebServlet;
import java.util.Date;

/**
 *
 */
@Theme("mytheme")
@Widgetset("be.vdab.contacts.MyAppWidgetset")
public class MyUI extends UI {
    MyDesign myDesign = new MyDesign();
    private Button contactsButton = myDesign.getContactsButton();
    private Button registrationButton = myDesign.getRegistrationButton();
    private Button loginButton = myDesign.getLoginButton();
    private Label label = myDesign.getContentLabel();
    private Layout contentVerticalLayout = myDesign.getContentVerticalLayout();
    private InlineDateField dateField = new InlineDateField("Datum");

    private FormLayout formLayout =new FormLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Contact person = new Contact("Daenarys", "Targaryen", Gender.FEMALE, new Date(28 / 04 / 1986));
        setContent(myDesign);
        contactsButton.setDescription("This button might give a 404.");
        dateField.setResolution(Resolution.DAY);
        contentVerticalLayout.addComponent(dateField);
        contentVerticalLayout.addComponent(formLayout);
        dateField.setVisible(false);
        final BeanFieldGroup<Contact> binder = new BeanFieldGroup<Contact>(Contact.class);
        binder.setItemDataSource(person);
        formLayout.addComponent(binder.buildAndBind("Firstname", "firstName"));
        formLayout.addComponent(binder.buildAndBind("Lastname", "lastName"));
        formLayout.addComponent(binder.buildAndBind("Gender", "gender", ComboBox.class));
        formLayout.addComponent(binder.buildAndBind("Birthdate", "birthDate"));
        binder.setBuffered(true);
        formLayout.addComponent(new Button("Ok", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent clickEvent) {
                try {
                    binder.commit();
                } catch (FieldGroup.CommitException e) {
                }
            }
        }));
        formLayout.addComponent(new Button("Reset", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent clickEvent) {
                binder.clear();
            }
        }));
        contactsButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent clickEvent) {
                label.setCaption("This is the contact page.");
                Notification.show("This is a Jaden Smith Error."
                        , "Error 404: Page doesn't exist, but in the end what does and does not exist? Aren't we all just creations of the human mind.",
                        Notification.Type.WARNING_MESSAGE);
                dateField.setVisible(false);
                formLayout.setVisible(false);
            }
        });
        registrationButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent clickEvent) {
                label.setCaption("This is the registration page.");
                dateField.setVisible(false);
                formLayout.setVisible(true);
            }
        });
        loginButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent clickEvent) {
                label.setCaption("This is the login page.");
                dateField.setVisible(true);
                formLayout.setVisible(false);
            }
        });


    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }


}
