import org.apache.jena.rdf.model.*;

public class JenaRDF extends Object{
    public static void main(String[] args) {
        String personURI = "http://somewhere/person#john";
        String genidURI = "genid:A30163";

        String nameSpace = "http://somewhere/person#";

        String givenName = "John";
        String familyName = "Smith";
        String nickName = "JS";
        String fullName = givenName+" "+familyName;

        Model model = ModelFactory.createDefaultModel();

        Property nsName = model.createProperty(nameSpace+"Name");
        Property nsGiven = model.createProperty(nameSpace+"Given");
        Property nsFamily = model.createProperty(nameSpace+"Family");
        Property nsNickName = model.createProperty(nameSpace+"NickName");
        Property nsFullName = model.createProperty(nameSpace+"FullName");


        Resource johnSmith=
                model.createResource(personURI).addProperty(nsFullName, fullName)
                .addProperty(nsNickName, nickName)
                .addProperty(nsName, model.createResource(genidURI)
                    .addProperty(nsGiven,givenName)
                    .addProperty(nsFamily, familyName));

        model.write(System.out);

    }
}
