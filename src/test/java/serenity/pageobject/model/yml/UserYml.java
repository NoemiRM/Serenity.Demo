package serenity.pageobject.model.yml;

/**
 * Created by NoemiRM on 16/01/23
 */
public class UserYml {
    private String name;
    private String lastname;
    private String type_doc;
    private String doc_number;
    private String cellphone;

    public UserYml() {
    }

    public UserYml(String name, String lastnameUser, String type_doc, String doc_number, String cellphone) {
        this.name = name;
        this.lastname = lastnameUser;
        this.type_doc = type_doc;
        this.doc_number = doc_number;
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getType_doc() {
        return type_doc;
    }

    public void setType_doc(String type_doc) {
        this.type_doc = type_doc;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return "UserYml{" +
                "namer='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", type_doc='" + type_doc + '\'' +
                ", doc_number='" + doc_number + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
