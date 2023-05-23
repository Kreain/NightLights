package org.plugins.nightlights.time;

public class NightLightTime {

    private final int ticks;
    private final int hours;
    private final int minutes;

    public NightLightTime(int hours, int minutes)
    {
        this.hours = hours + 6 > 23 ? hours + 6 - 24 : hours + 6;
        this.minutes = minutes;
        this.ticks = timeToTicks(hours, minutes);
    }

    public NightLightTime(int ticks)
    {
        this.ticks = ticks;
        this.hours = ticksToHours(ticks);
        this.minutes = ticksToMinutes(ticks);
    }

    public int timeToTicks(int hours, int minutes)
    {
        return (int) ((hours * 1000) + (minutes * 16.6));
    }

    public int ticksToHours(int ticks)
    {
        int hours = ticks / 1000 + 6;

        return hours > 23 ? hours - 24 : hours;
    }

    public int ticksToMinutes(int ticks)
    {
        int hours = ticks / 1000;

        return (int) ((ticks - (hours * 1000)) / 16.6);
    }

    public int getTicks() { return (ticks); }
    public int getHours() { return (hours); }
    public int getMinutes() { return (minutes); }
    public String getTime() { return (hours + "h" + minutes); }
}
