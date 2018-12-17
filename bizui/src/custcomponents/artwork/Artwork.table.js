
import React, { PureComponent } from 'react'
import moment from 'moment'
import { Table, Alert, Badge,Modal,Input} from 'antd'
import { Link } from 'dva/router'
import ImagePreview from '../../components/ImagePreview'
import GlobalComponents from '../../custcomponents';
import ArtworkTable from '../../bizcomponents/artwork/Artwork.table'
import styles from './Artwork.table.less'
import ArtworkServiceEx from './Artwork.serviceex'
import { notification } from 'antd'
class ArtworkTableEx extends PureComponent {
  
  state = {
    selectedRowKeys: [],
    data:[],
    currentRecord:{}
  }
  //const {data}=this.props
  componentWillReceiveProps(nextProps) {
    // clean state
    if (nextProps.data) {
      this.setState({
        data: nextProps.data,
      })
    }
  }

  updateArtworkPostTime = (parameters) => {
    //const { BookService } = GlobalComponents;
  
    
    const future = ArtworkServiceEx.updateArtworkPostTime(parameters);
    //console.log(future);
  
    future.then(executeResult => {
      console.log("adding result", executeResult)
      if(!executeResult.class){
        notification.error({
          message: "服务器端出错",
          description: "服务器出错，请尝试重新登录",
        })
        return
      }
  
      if(executeResult.class.indexOf("Exception")>0){
  
        notification.error({
          message: "状态错误",
          description: executeResult.message,
        })
        return
      }
      notification.success({
        message: "执行成功",
        description:"执行成功",
      })
      
  
    });
    
  };


  handleOk = () =>{
    this.setState({visible:false})
    const {currentRecord , currentDate}= this.state
    const artworkVersion = currentRecord.version
    const artworkId = currentRecord.id
    const newValueExpr = currentDate
    const parameters={artworkId,artworkVersion,newValueExpr}
    this.updateArtworkPostTime(parameters)



  }
  handleCancel = (text, record) =>{
    this.setState({visible:false})
  }
  renderDateTime=(value, record)=>{
    return moment(value).format('YYYY-MM-DDTHH:mm');	
  }
  modifyTime = (text, record) =>{
    console.log(record)
    const currentDate = this.renderDateTime(record.postTime,record)

    const title = `${record.artworkName}@${currentDate} `
    const currentRecord = record
    this.setState({visible:true,currentDate,title,currentRecord})
  }
  onChange = (event) => {
    const { value } = event.target;
    this.setState({ currentDate:value })
    
    /*
    const newData = this.state.data
    if(!newData){
      
      return
    }
    const {currentRecord} = this.state
    const index = newData.findIndex(item => item.id == currentRecord.id);
    if (index > -1) {
        const item = newData[index];
        newData.splice(index, 1, {
          ...item,
          ...currentRecord,
        });
        this.setState({ data: newData, currentDate:value  });
        return
    } 
    */

  }



  gotoEdit = (text, record) =>{
    
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

 calcDisplayColumns=()=>{

    const {owner} =  this.props
    const {referenceName} = owner
   
    const {ArtworkBase} = GlobalComponents
    const {displayColumns} = ArtworkBase
    if(!referenceName){
      return displayColumns
    }
    const remainColumns = displayColumns.filter((item,index)=> item.dataIndex!=referenceName&&index<7&&item.dataIndex!=='content')
    //fixed: 'right',
    const operationColumn={
      title: '操作',
      render: (text, record) => (
        <span>
          
          <Link to={`/artwork/${record.id}/dashboard`}>{'查看'}</Link>
          <span className={styles.splitLine} /><a key="__2" onClick={()=>this.gotoEdit(text, record)}>编辑</a>
          <span className={styles.splitLine} /><a key="__3" onClick={()=>this.modifyTime(text, record)}>更改时间</a>
          

          {
            record.actionList&&record.actionList.map((item)=>(<a key={item.actionId} onClick={()=>this.executeAction(item,text, record)}><span className={styles.splitLine} />{item.actionName}</a>))

          }
        </span>
      ),
    }
   
    remainColumns.push(
      operationColumn
    )
    
    return remainColumns

  }
  /*
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
import ArtworkTable from '../custcomponents/artwork/Artwork.table'

const result={ArtworkTable}


  }*/
  
  

	
  render() {
   
    return (
      <div>
        <ArtworkTable
          calcDisplayColumns={this.calcDisplayColumns}
          data={this.state.data}
          {...this.props}
        />
        
        <Modal
          title={this.state.title}
          visible={this.state.visible}
          onOk={this.handleOk}
          onCancel={this.handleCancel}
        >
          <Input value={this.state.currentDate} onChange={this.onChange}/>
        </Modal>
        </div>
     
    )
  }
}

export default ArtworkTableEx

