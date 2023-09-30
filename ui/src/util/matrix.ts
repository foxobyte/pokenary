function multiplyMatrix(matrix: number[][], tm: number[][]): number[][] {
    var m = matrix.length;
    var n = tm[0].length;
    let newMatrix = Array();

    for (let i = 0; i < m; i++) {
        let row = Array();

        for (let j = 0; j < n; j++) {
            let sum1 = 0;

            for (let k = 0; k < tm.length; k++) {
                sum1 += matrix[i][k] * tm[k][j];
            }

            row.push(sum1);
        }

        newMatrix.push(row);
    }

    return newMatrix;
}

export default multiplyMatrix;