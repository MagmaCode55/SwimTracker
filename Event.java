public class Event {
    public int eventId = 0;
    private double _25yardDashTime = 0.0;
    private double _50yardDashTime = 0.0;
    private double _100yardDashTime = 0.0;
    private double _400yardSwimTime = 0.0;

    public Event(int id, double _25yard, double _50yard, double _100yard, double _400yard){
        _25yardDashTime = _25yard;
        _50yardDashTime = _50yard;
        _100yardDashTime = _100yard;
        _400yardSwimTime = _400yard;
        eventId = id;
    }

    
    public int getEventId(){
        return eventId;
    }

    public double get25yardTime(){
        return _25yardDashTime;
    }

    public double get50yardTime(){
        return _50yardDashTime;
    }

    public double get100yardTime(){
        return _100yardDashTime;
    }

    public double get400yardTime(){
        return _400yardSwimTime;
    }

    public void setEventId(int id){
        eventId = id;
    }

    public void set25yardTime(double time){
        this._25yardDashTime = time;
    }

    public void set50yardTime(double time){
        this._50yardDashTime = time;
    }

    public void set100yardTime(double time){
        this._100yardDashTime = time;
    }

    public void set400yardTime(double time){
        this._400yardSwimTime = time;
    }
    @Override
    public String toString(){
        return "\nEvent Id: "+ eventId +
                " | 25 yard time: " + _25yardDashTime + 
                " | 50 yard time: " + _50yardDashTime +
                " | 100 yard time: " + _100yardDashTime +
                " | 400 yard time: " + _400yardSwimTime; 
    }
}
