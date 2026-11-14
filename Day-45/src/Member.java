public class Member {
    private final String memberId;
    private final String name;
    private final String email;
    public Member(String memberId, String name, String email) {
        this.memberId = clean(memberId);
        this.name = clean(name);
        this.email = clean(email);
    }
    private static String clean(String value) {
        return value == null ? "" : value.trim().replace("|", "/").replace("\n", " ");
    }
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String toFileLine() {
        return memberId + "|" + name + "|" + email;
    }
    public static Member fromFileLine(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length != 3) throw new IllegalArgumentException("Invalid member record");
        return new Member(p[0], p[1], p[2]);
    }
    @Override
    public String toString() {
        return String.format("Member ID: %s | Name: %s | Email: %s", memberId, name, email);
    }
}