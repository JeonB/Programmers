class TreeNode {
  constructor(idx, x, y) {
    this.idx = idx;
    this.x = x;
    this.y = y;
    this.left = null;
    this.right = null;
  }
}

function buildTree(nodes) {
  if (!nodes.length) return null;
  
  const rootNode = nodes[0];
  const root = new TreeNode(rootNode.idx, rootNode.x, rootNode.y);
  
  for (let i = 1; i < nodes.length; i++) {
    insertNode(root, new TreeNode(nodes[i].idx, nodes[i].x, nodes[i].y));
  }
  
  return root;
}

function insertNode(parent, child) {
  if (child.x < parent.x) {
    if (parent.left) insertNode(parent.left, child);
    else parent.left = child;
  } else {
    if (parent.right) insertNode(parent.right, child);
    else parent.right = child;
  }
}

function preorder(node, result) {
  if (!node) return;
  result.push(node.idx);
  preorder(node.left, result);
  preorder(node.right, result);
}

function postorder(node, result) {
  if (!node) return;
  postorder(node.left, result);
  postorder(node.right, result);
  result.push(node.idx);
}

function solution(nodeinfo) {
  const nodes = nodeinfo.map(([x, y], idx) => ({ x, y, idx: idx + 1 }));
  nodes.sort((a, b) => b.y - a.y || a.x - b.x); // y 기준 내림차순, x 기준 오름차순 정렬
  
  const root = buildTree(nodes);
  const preorderResult = [];
  const postorderResult = [];
  
  preorder(root, preorderResult);
  postorder(root, postorderResult);
  
  return [preorderResult, postorderResult];
}
