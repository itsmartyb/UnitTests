package basics;

public class Client {
    private static final int IDENT = 2;
    private final Service service;
    private ContentFormat format;

    public Client(final Service service) {
        if (service == null) {
            throw new IllegalArgumentException("Parameter 'service' must not be empty!");
        }
        this.service = service;
    }

    public Client(final Service service, final ContentFormat format) {
        this(service);
        this.format = format;
    }

    public void release() {
        service.release();
    }

    public String getServiceName() {
        String name = service.getName();
        service.release();
        return name;
    }

    public String getContent(final Long ident) {
        service.connect();
        String result = service.getContent(ident);
        service.release();
        return result;
    }

    public String getContentFormatted(final Long ident) {
        String content = getContent(ident);
        return format.format(content);
    }

    public String getClientContentFormatted() {
        StringBuilder content = new StringBuilder();
        content.append("This is a client ");
        content.append(IDENT);
        content.append("!");
        return format.format(content);
    }

    public String getStartup(final String dateFormat) {
        return service.getTimestamp(dateFormat);
    }
}
