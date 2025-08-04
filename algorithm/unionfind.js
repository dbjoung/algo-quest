/*
// 부모 노드 합치는 함수
function getParent(parent, x) {
  if (parent[x] == x) return x;
  parent[x] = getParent(parent, parent[x]);
  return parent[x];
}

// 두 부모 노드를 합치는 함수
function unionParent(parent, a, b) {
  a = getParent(parent, a);
  b = getParent(parent, b);
  if (a < b) parent[b] = a;
  else parent[a] = b;
}

// 같은 부모를 가지는 지 확인
function findParent(parent, a, b) {
  a = getParent(parent, a);
  b = getParent(parent, b);

  if (a == b) return true;
  else return false;
}

const parent = new Array(11).fill(0).map((_, i) => i);
unionParent(parent, 1, 2);
unionParent(parent, 2, 3);
unionParent(parent, 3, 4);
unionParent(parent, 5, 6);
unionParent(parent, 6, 7);
unionParent(parent, 7, 8);

console.log(parent);
*/

function getParent(parent, a) {
  if (parent[a] == a) return a;
  parent[a] = getParent(parent, parent[a]);
  return parent[a];
}

function unionParent(parent, a, b) {
  const aroot = getParent(parent, a);
  const broot = getParent(parent, b);

  if (aroot < broot) parent[broot] = aroot;
  else parent[aroot] = broot;
}

function findUnion(parent, a) {
  return getParent(parent, a);
}

const parent = new Array(11).fill(0).map((_, i) => i);
unionParent(parent, 1, 2);
unionParent(parent, 2, 3);
unionParent(parent, 3, 4);
unionParent(parent, 5, 6);
unionParent(parent, 7, 8);

unionParent(parent, 4, 5);

console.log(parent);

console.log(findUnion(parent, 6));

console.log(parent);
