
import React, { PureComponent } from 'react'
import moment from 'moment'
import { Table, Alert, Badge} from 'antd'
import { Link } from 'dva/router'
import styles from './UserWhiteList.table.less'
import ImagePreview from '../../components/ImagePreview'
import GlobalComponents from '../../custcomponents';
import UserWhiteListBase from './UserWhiteList.base'
import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
const  {  hasCreatePermission,hasExecutionPermission,hasDeletePermission,hasUpdatePermission,hasReadPermission } = PermissionSettingService


class UserWhiteListTable extends PureComponent {
  state = {
    selectedRowKeys: [],
  }

  componentWillReceiveProps(nextProps) {
    // clean state
    if (nextProps.selectedRows.length === 0) {
      this.setState({
        selectedRowKeys: [],
      })
    }
  }

  handleRowSelectChange = (selectedRowKeys, selectedRows) => {
    if (this.props.onSelectRow) {
      this.props.onSelectRow(selectedRows)
    }
    this.setState({ selectedRowKeys })
  }

  handleTableChange = (pagination, filters, sorter) => {
    this.props.onChange(pagination, filters, sorter)
  }

  cleanSelectedKeys = () => {
    this.handleRowSelectChange([], [])
  }
  
  enhanceColumnsWithSorter=()=>{
    const {displayColumns} = UserWhiteListBase
    const {owner, searchParameters} =  this.props
    const {referenceName, listName} = owner
    if(!referenceName){
      return displayColumns
    }
    const remainColumns = displayColumns.filter((item,index)=> item.dataIndex!==referenceName&&index<7&&item.dataIndex!=='content')
    
    if(!searchParameters){
      return remainColumns
    }
    if(!searchParameters[listName]){
      return remainColumns
    }
    const sorter = {field: searchParameters[`${listName}.orderBy.0`], order:searchParameters[`${listName}.descOrAsc.0`]}
    console.log("sorter in table", sorter)
    const convertSorter=(targetSorter)=>{
      if(targetSorter.order==="desc"){
        return "descend"
      }
      return "ascend"

    }
    const enhancedColumns = remainColumns.map(item=>{
      if(sorter.field===item.dataIndex){
        return {...item, sortOrder: convertSorter(sorter)}
      }
      return item
    })
    return enhancedColumns

  }
  
  calcDisplayColumns=()=>{

    const { metaInfo} =  this.props
    const userContext = null
    const enhancedColumns = this.enhanceColumnsWithSorter()
    
    const operationColumn={
      title: appLocaleName(userContext,"Operate"),
      render: (text, record) => (
        <span>
          
          { hasReadPermission(metaInfo)&&<Link to={`/userWhiteList/${record.id}/dashboard`}>{appLocaleName(userContext,"View")}</Link>}

          {  hasUpdatePermission(metaInfo)&&<span className={styles.splitLine} /> } {hasUpdatePermission(metaInfo)&&<a key="__2" onClick={()=>this.gotoEdit(text, record)}>{appLocaleName(userContext,"Edit")}</a>}

          {
            record.actionList&&record.actionList.map((item)=>(<a key={item.actionId} onClick={()=>this.executeAction(item,text, record)}><span className={styles.splitLine} />{item.actionName}</a>))

          }
        </span>
      ),
    }
   
    enhancedColumns.push(
      operationColumn
    )
    
    return enhancedColumns

  }
  executeAction = (action, text, record) => {
    console.log("executeAction",action)
    const {dispatch,owner} = this.props
    const {actionPath}=action;
    const url = actionPath
    const successAction={

      type:`${owner.type}/view`,
      payload: {id:`${owner.id}`}

    }
    dispatch({
      type:"actioncenter/executeAction",
      payload:{action,url,successAction}

    })



  }
  
  gotoEdit = (text, record) =>{
    this.handleRowSelectChange([record.id], [record])
    const{dispatch,owner,role} = this.props
    const selectedRows = [];
    selectedRows.push(record)
    console.log("selectedRows",selectedRows)

    if(selectedRows.length<1){
      return
    }
    const currentUpdateIndex = 0
    dispatch({
      type: `${owner.type}/gotoUpdateForm`,
      payload: {
        id: owner.id,
        role: role,
        selectedRows,
        currentUpdateIndex,
      },
    })

  }
	
  render() {
    const { selectedRowKeys } = this.state
    // const { data, count, current, owner } = this.props
    const { data, count, current } = this.props
	const calcDisplayColumns = this.props.calcDisplayColumns||this.calcDisplayColumns
	const userContext = null
    const paginationProps = {
      pageSize: 20,
      total: count,
      current,
      
    }

    const rowSelection = {
      selectedRowKeys,
      onChange: this.handleRowSelectChange,
      getCheckboxProps: record => ({
        disabled: record.disabled,
      }),
    }

    return (
      <div className={styles.standardTable}>
        <div className={styles.tableAlert}>
          <Alert
            message={selectedRowKeys.length===0?(
              <span>
                {appLocaleName(userContext,"Totally")} <a style={{ fontWeight: 600 }}>{count}</a> {appLocaleName(userContext,"Items")}, {appLocaleName(userContext,"PleaseSelectItemtoProceed")} 
              </span>
            ):(
              <span>
                {appLocaleName(userContext,"Totally")} <a style={{ fontWeight: 600 }}>{count}</a> {appLocaleName(userContext,"Items")} 
                {appLocaleName(userContext,"Selected")} <a style={{ fontWeight: 600 }}>{selectedRowKeys.length}</a> {appLocaleName(userContext,"Items")} <a onClick={this.cleanSelectedKeys} style={{ marginLeft: 24 }}>{appLocaleName(userContext,"Clear")}</a>
              </span>
            )}
            type="info"
            showIcon
          />
        </div>
        <Table
          loading={false}
          size="default"
          rowKey={record => record.id}
           
          rowSelection={rowSelection}
          
          dataSource={data}
          columns={calcDisplayColumns()}
          pagination={paginationProps}
          onChange={this.handleTableChange}
          
        />
      </div>
    )
  }
}

export default UserWhiteListTable

