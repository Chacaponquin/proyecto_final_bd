package cu.edu.cujae.structbd.services;


public abstract class ServicesLocator {
    public static BatterServices BatterServices = new BatterServices();
    public static CoachServices CoachServices = new CoachServices();
    public static GameServices GameServices = new GameServices();
    public static PhaseServices PhaseServices = new PhaseServices();
    public static PitcherServices PitcherServices = new PitcherServices();
    public static PlayerServices PlayerServices = new PlayerServices();
    public static PositionServices PositionServices = new PositionServices();
    public static ProvinceServices ProvinceServices = new ProvinceServices();
    public static StadiumServices StadiumServices = new StadiumServices();
    public static TeamServices TeamServices = new TeamServices();
    public static UserServices UserServices = new UserServices();
    public static TeamMemberServices TeamMemberServices = new TeamMemberServices();
    public static AppServices AppServices = new AppServices();

}
