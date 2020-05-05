import React from 'react'
import { Tree, Input, Tabs, Radio, Menu, Dropdown } from 'antd';

const { Search } = Input;

const { TabPane } = Tabs;

const subList = (listData, searchValue) => {
  console.log("subList", listData)
  return listData.filter(item => item.name && item.name.indexOf(searchValue) >= 0)
}
const allKeys = (listData) => {
  return listData.map(item => item.id)
}




const genTree = (listData, searchValue) => {

  const parentNodes = [];
  const rootTree = { children: [] }
  subList(listData, searchValue)
    .map(item => {

      const { valuesOfGroupBy } = item
      const child = { title: item.name, key: item.id }
      const { length } = valuesOfGroupBy
      if (valuesOfGroupBy && length === 0) {
        // no parent node, the child it self is the root 
        rootTree.children.push(child)
        return
      }
      const itemParentNodes = []
      itemParentNodes.push(rootTree)
      // enrich all ancestors
      valuesOfGroupBy.forEach((groupItem, index) => {
        const key = `${groupItem}-${index}`
        const itemParentNode = parentNodes[key]
        if (!itemParentNode) {
          // if there are no node registered, then add it
          const newRootItem = { title: groupItem, key, level: index, children: [] }
          parentNodes[key] = newRootItem
          itemParentNodes.push(newRootItem)
          return
        }
        // found! then push to parent nodes
        itemParentNodes.push(itemParentNode)

      }
      )
      itemParentNodes.push(child)


      // connect to all the ancestors
      itemParentNodes.forEach((node, index) => {

        if (index > 0) {
          const prev = itemParentNodes[index - 1]
          const current = itemParentNodes[index]
          if (prev.children.filter(childItem => childItem.key === current.key).length === 0) {
            prev.children.push(current)
          }
        }
      })
      return { ...item, itemParentNodes }
      // ensure parent nodes


    })

  return rootTree.children


}

/*

 <TreeSearch className={styles.tableList} 
                            callbackFunction={callbackFunction}
                            callbackParameters={callbackParameters}
                        />

*/

const globalVars = { values: [],selectedTab:"" }
const leftChars = (value, left) => {
  const chars = left || 4
  if (!value) {
    return "N/A"
  }
  return value.substring(0, chars);
}


export default class TreeGroupSearch extends React.Component {
  state = {
    expandedKeys: allKeys(globalVars.values),
    searchValue: '',
    candidateValues: globalVars.values,
    autoExpandParent: true,
    selectedTab: globalVars.selectedTab,
  };

  componentDidMount() {

    const { candidateValues } = this.state
    if (candidateValues.length > 0) {
      return;
    }

    this.mounted = true;
    const { callbackFunction, callbackParameters } = this.props
    if (!callbackFunction || !callbackParameters) {
      return
    }

    const future = callbackFunction(callbackParameters)
    const { extraTargetTypes } = this.props
    const defaultKey = globalVars.selectedTab || this.state.selectedTab || extraTargetTypes[0]
    future.then(data => {
      if (this.mounted) {
        console.log("data==========>", data)
        const candidateValues = data
        globalVars.values = data
        globalVars.selectedTab = defaultKey
        this.setState({ candidateValues, expandedKeys: allKeys(data),selectedTab:defaultKey})
      }
    })

  }

  componentWillUnmount() {
    this.mounted = false;
  }

  onExpand = expandedKeys => {
    this.setState({
      expandedKeys,
      autoExpandParent: false,
    });
  };

  onChange = e => {
    const { value } = e.target;
    const { candidateValues } = this.state
    const expandedKeys = subList(candidateValues, value)
      .map(item => {

        return item.id;
      })
    this.setState({
      expandedKeys,
      searchValue: value,
      autoExpandParent: true,
    });
  };

  onSelect = (selectedKeys, info) => {
    console.log('selected', selectedKeys, info);
  };


  onTabChange = (activeKey, info) => {
    console.log('onTabChange to', activeKey);
    globalVars.selectedTab = activeKey
    this.setState({ selectedTab: activeKey })
  }

  showTreeGroupView = () => {

    const { extraTargetTypes } = this.props
    const {selectedTab} = this.state

    
    console.log("extraTargetTypes", extraTargetTypes)
    return (
      <div style={{ height: '100%' }}>
        <Search style={{ marginBottom: 4 }} placeholder="搜索分类" onChange={this.onChange} />
        <Tabs tabBarGutter={0} defaultActiveKey={selectedTab} size={"small"} tabBarStyle={{ fontSize: "10px" }} onChange={this.onTabChange}>

          {extraTargetTypes.map(item => (
            <TabPane tab={<div style={{ fontSize: "12px" }}>{leftChars(item)}</div>} key={item} >
              {this.showTreeData()}
            </TabPane>)

          )}



        </Tabs>


      </div>)

  }


  showTreeGroupView3 = () => {

    const { extraTargetTypes } = this.props


    const defaultKey = this.state.selectedTab || extraTargetTypes[0]
    console.log("extraTargetTypes", extraTargetTypes)
    return (
      <div style={{ height: '100%' }}>
        <Search style={{ marginBottom: 4 }} placeholder="搜索分类" onChange={this.onChange} />

        <Dropdown overlay={menu}>
          <a className="ant-dropdown-link" onClick={e => e.preventDefault()}>
            Hover me
          </a>
        </Dropdown>,

        {this.showTreeData()}


      </div>)

  }

  showTreeData = () => {
    const { searchValue, expandedKeys, autoExpandParent, candidateValues } = this.state;
    const { handleSelectNode } = this.props
    const treeData = genTree(candidateValues, searchValue)
    const onSelectNode = handleSelectNode || this.onSelect

    if (treeData && treeData.length > 0) {
      return (<Tree
        defaultExpandAll
        onExpand={this.onExpand}
        expandedKeys={expandedKeys}
        autoExpandParent={autoExpandParent}
        onSelect={onSelectNode}
        treeData={treeData}
      />)

    }

    return <div>请重新输入搜索条件</div>

  }


  showSingleTreeView = () => {



    return (<div style={{ marginRight: "10px", minHeight: '700px' }}>
      <Search style={{ marginBottom: 8 }} placeholder="搜索分类" onChange={this.onChange} />

      {this.showTreeData()}


    </div>)

  }

  showTreeViewOrGroup = () => {



    const { extraTargetTypes } = this.props

    if (extraTargetTypes && extraTargetTypes.length === 1) {

      return this.showSingleTreeView()

    }

    return this.showTreeGroupView()




  }


  render() {
    const { candidateValues } = this.state;
    if (candidateValues && candidateValues.length < 0) {
      return <div>请等待</div>
    }

    return this.showTreeViewOrGroup();
  }
}

