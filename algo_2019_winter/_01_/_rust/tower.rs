fn main() {
    println!("\n# solution: {:?}", solution(&[6,9,5,7,4]));
    println!("\n# solution: {:?}", solution(&[3,9,9,3,5,7,2]));
    println!("\n# solution: {:?}", solution(&[1,5,3,6,7,6,5]));
}

fn solution(heights: &[i32]) -> Vec<usize>{
    let mut answer = vec![0; heights.len()];
    for i in (0..heights.len()).rev() {
        // print!("\nsender -> heights[{}]: {}\n", i, heights[i]);
        for j in (0..i).rev() {
            if heights[j] > heights[i] {
                // print!("receiver -> heights[{}]: {}\n", j, heights[j]);
                answer[i] = j + 1;
                break;
            }
        }
        // println!("answer: \t{:?}", answer);
    }
    return answer;
}