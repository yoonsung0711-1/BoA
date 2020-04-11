use std::collections::HashMap;

#[allow(dead_code)]
fn main() {
    println!("{}", solution(&[ "mislav", "stanko", "mislav", "ana" ], &[ "stanko", "ana", "mislav" ]));
    println!("{}", solution(&[ "marina", "josipa", "nikola", "vinko", "filipa"	], &["josipa", "filipa", "marina", "nikola"]));
    println!("{}", solution(&[ "mislav", "stanko", "mislav", "ana"]	, &["stanko", "ana", "mislav"]));
}

pub fn solution(_participant: &[&str], _completion: &[&str]) -> String {
    let mut p_map: HashMap<&str, i32>= HashMap::new();
    for p in _participant.iter() {
        if p_map.contains_key(p) {
            *p_map.get_mut(p).unwrap() += 1;
        } else {
            p_map.insert(p, 1);
        }
    }
    println!("# participants \n\t{:?}\n", p_map);

    for c in _completion.iter() {
        *p_map.get_mut(c).unwrap() -= 1;
    }
    println!("# completors \n\t{:?}\n", p_map);

    p_map.retain(|&_k, &mut v| v > 0);

    println!("# unfulfilled\n\t{:?}\n", p_map);

    return p_map.iter().fold(String::new(), |acc, (&k,_) | { acc + &k.to_string() });
}
