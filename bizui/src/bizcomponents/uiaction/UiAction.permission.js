

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './UiAction.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (uiAction,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{uiAction.id}</Description> 
<Description term="代码">{uiAction.code}</Description> 
<Description term="图标">{uiAction.icon}</Description> 
<Description term="头衔">{uiAction.title}</Description> 
<Description term="顺序">{uiAction.displayOrder}</Description> 
<Description term="短暂的">{uiAction.brief}</Description> 
<Description term="图片链接"><ImagePreview imageTitle="图片链接" imageLocation={uiAction.imageUrl}/></Description> 
<Description term="链接网址">{uiAction.linkToUrl}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = uiAction => {
  const {UiActionBase} = GlobalComponents
  return <PermissionSetting targetObject={uiAction}  targetObjectMeta={UiActionBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class UiActionPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  uiAction = this.props.uiAction
    const { id,displayName,  } = uiAction
    const  returnURL = `/uiAction/${id}/workbench`
    const cardsData = {cardsName:"用户界面操作",cardsFor: "uiAction",cardsSource: uiAction,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  uiAction: state._uiAction,
}))(Form.create()(UiActionPermission))

