//use math::round;

const MAX_CARS_PER_HOUR: f64 = 221.0;

fn success_rate_by_speed(speed: u8) -> f64 {
    if speed <= 4 {
        100.0
    } else if speed <= 8 {
        90.0
    } else {
        77.0
    }
}

pub fn production_rate_per_hour(speed: u8) -> f64 {
    MAX_CARS_PER_HOUR * (speed as f64) * success_rate_by_speed(speed) / 100.0
}

pub fn working_items_per_minute(speed: u8) -> u32 {
    (production_rate_per_hour(speed) / 60.0) as u32
}
