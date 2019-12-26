
import React from 'react'
import { Collapse,AutoComplete, Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'

import G6 from '@antv/g6'




function refreshDragedNodePosition(e) {
  const model = e.item.get('model');
  model.fx = e.x;
  model.fy = e.y;
}

export default class Graph extends React.Component {
  



  componentDidMount() {
    const width = document.getElementById('container').scrollWidth;
    const height = document.getElementById('container').scrollHeight || 500;
    const graph = new G6.Graph({
      container: 'container',
      modes: {
        default: [ 'drag-canvas', 'drag-node' ]
      },
      width,
      height,
      layout: {
        type: 'force',
        preventOverlap: true,
        linkDistance: d => {
          if(d.depth===1){
            return 800;
          }
          return 400
          
        },
        nodeStrength: d => {
          if (d.size >= 50) {
            return 100;
          }
          return 0;
        },
        edgeStrength: d => {
          if(d.depth === 2){
            return 0.3
          }
          return 0.8;
        }
      },
      defaultNode: {
        size: 90,
        color: '#5B8FF9',
        style: {
          lineWidth: 6,
          fill: '#C6E5FF'
        }
      },
      defaultEdge: {
        
        style: {
          stroke: 'grey',
        },
        labelCfg: {
          autoRotate: true,
          
        }
      },
    });

    const data = {
      nodes: [
    {"label":"王亚彪","id":"王亚彪"},
    {"label":"雷莉","id":"雷莉"},
    {"label":"胡靖","id":"胡靖"},
    {"label":"赵之成","id":"赵之成"},
    {"label":"王云","id":"王云"},
    {"label":"曾波","id":"曾波"},
    {"label":"李佳","id":"李佳"},
    {"label":"王敏","id":"王敏"},
    {"label":"熊代德","id":"熊代德"},
    {"label":"王丰","id":"王丰"},
    {"label":"赵丽娟","id":"赵丽娟"},
    {"label":"哈尔滨成都银行","id":"哈尔滨成都银行"},
    {"label":"方兰舰","id":"方兰舰"},
    {"label":"谢国锦","id":"谢国锦"},
    {"label":"付蝶","id":"付蝶"},
    {"label":"张贸","id":"张贸"},
    {"label":"曹琳","id":"曹琳"},
    {"label":"任昭兵","id":"任昭兵"},
    {"label":"郭林","id":"郭林"},
    {"label":"张梦莲","id":"张梦莲"},
    {"label":"李清兆","id":"李清兆"},
    {"label":"幸红林","id":"幸红林"}
      ],
      edges: [
        {"source":"王敏","target":"赵之成","label":"委托"},
        {"source":"赵之成","target":"王敏","label":"被委托"},
        {"source":"王敏","target":"张梦莲","label":"委托"},
        {"source":"张梦莲","target":"王敏","label":"被委托"},
        {"source":"王敏","target":"郭林","label":"委托"},
        {"source":"郭林","target":"曹琳","label":"被委托"},
        {"source":"曹琳","target":"李清兆","label":"赠与"},
        {"source":"李清兆","target":"曹琳","label":"受赠"},
        {"source":"曹琳","target":"王亚彪","label":"遗赠"},
        {"source":"王亚彪","target":"赵之成","label":"受赠"},
        {"source":"赵之成","target":"胡靖","label":"认领"},
        {"source":"胡靖","target":"赵之成","label":"被认领"},
        {"source":"赵之成","target":"雷莉","label":"已婚"},
        {"source":"雷莉","target":"赵之成","label":"已婚"},
        {"source":"赵之成","target":"付蝶","label":"离婚"},
        {"source":"付蝶","target":"赵之成","label":"离婚"},
        {"source":"赵之成","target":"幸红林","label":"离婚"},
        {"source":"幸红林","target":"张梦莲","label":"离婚"},
        {"source":"张梦莲","target":"任昭兵","label":"已婚"},
        {"source":"任昭兵","target":"郭林","label":"已婚"},
        {"source":"郭林","target":"谢国锦","label":"已婚"},
        {"source":"谢国锦","target":"王敏","label":"已婚"},
        {"source":"王敏","target":"熊代德","label":"亲属"},
        {"source":"熊代德","target":"王敏","label":"亲属"},
        {"source":"王敏","target":"王丰","label":"亲属"},
        {"source":"王丰","target":"王敏","label":"亲属"},
        {"source":"王敏","target":"王云","label":"亲属"},
        {"source":"王云","target":"曹琳","label":"亲属"},
        {"source":"曹琳","target":"李清兆","label":"亲属"},
        {"source":"李清兆","target":"曹琳","label":"亲属"},
        {"source":"曹琳","target":"赵丽娟","label":"亲属"},
        {"source":"赵丽娟","target":"李清兆","label":"亲属"},
        {"source":"李清兆","target":"张贸","label":"收养"},
        {"source":"张贸","target":"王亚彪","label":"被收养"},
        {"source":"王亚彪","target":"曾波","label":"卖房"},
        {"source":"曾波","target":"王亚彪","label":"买房"},
        {"source":"王亚彪","target":"李佳","label":"卖房"},
        {"source":"李佳","target":"李清兆","label":"买房"},
        {"source":"李清兆","target":"曾波","label":"借款"},
        {"source":"曾波","target":"哈尔滨成都银行","label":"贷款"},
        {"source":"哈尔滨成都银行","target":"李佳","label":"借款"},
        {"source":"李佳","target":"哈尔滨成都银行","label":"贷款"},
        {"source":"哈尔滨成都银行","target":"王云","label":"借款"},
        {"source":"王云","target":"王云","label":"贷款"},
        {"source":"王云","target":"谢国锦","label":"清偿提存"},
        {"source":"谢国锦","target":"任昭兵","label":"被清偿提存"},
        {"source":"任昭兵","target":"方兰舰","label":"代办"},
      ],
    };

    const selectNodeName=(selectedNode, item)=>{
      if(selectedNode===item.source){
        return item.target
      }
      return item.source

    }
    const edgeMatch=(edge, nodeName)=>{
      return (edge.source===nodeName || edge.target===nodeName)
    }
    const subgraph=(data, selectNode)=>{
      const firstEdges=data.edges.filter(item=>edgeMatch(item,selectNode))
      .map(item=>({...item,depth:1,style: {
        stroke: '#dd6600', lineWidth: 10,
      }}))
	  
      const nodesKeys = {}
      firstEdges.forEach(item=>{
          nodesKeys[selectNodeName(selectNode,item)]=true
      })
      
      const secondEdges=[]
	  Object.keys(nodesKeys).forEach(node=>{
      		data.edges.filter(item=>edgeMatch(item,node)).forEach(edge=>{
            	secondEdges.push({...edge,depth:2})
            })
      })
      secondEdges.forEach(edge=>{
          if(edgeMatch(edge,selectNode)){
            return
          }
          nodesKeys[edge.source]=true
          nodesKeys[edge.target]=true
      })
      
      const nodes=Object.keys(nodesKeys).map(key=>({id:key,label:key}))
      const edges=firstEdges.concat(secondEdges)
	  
      nodes.push({id:selectNode,label:selectNode,size: 100,style:{fill:'yellow',line: 5}})
      return {nodes,edges}
    }	

    const newdata=subgraph(data,'王亚彪')




    const nodes = data.nodes;
    graph.data({
      nodes,
      edges: data.edges.map(function(edge, i) {
        edge.id = 'edge' + i;
        return Object.assign({}, edge);
      })
    });
    graph.render();

    graph.on('node:dragstart', function(e) {
      graph.layout();
      refreshDragedNodePosition(e);
    });
    graph.on('node:drag', function(e) {
      refreshDragedNodePosition(e);
    });
    graph.on('node:dragend', function(e) {
      e.item.get('model').fx = null;
      e.item.get('model').fy = null;
    });


    graph.on('node:click', ev => {
    const node = ev.item;
    const newdata=subgraph(data,node._cfg.id)

    console.log("node2",node._cfg.id)

    if(newdata.nodes.length<2){
      return
    }

    const nodes = newdata.nodes;
    graph.data({
      nodes,
      edges: newdata.edges.map(function(edge, i) {
        edge.id = 'edge1' + i;
        return Object.assign({}, edge);
      })
    });
    graph.render();
      //const edges = node.getEdges();
      //edges.forEach(edge => graph.setItemState(edge, 'running', true));
    });

  }
  componentWillUnmount() {
    
  }

  


  render() {
    

   

    return (
    
          <div id='container' style={{height:'1500px', width:'1500px'}}></div>
        
    
      
    )
  }
}