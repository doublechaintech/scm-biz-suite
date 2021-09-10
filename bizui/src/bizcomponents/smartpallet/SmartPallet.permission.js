

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SmartPallet.profile.less'
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
const internalSummaryOf = (smartPallet,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{smartPallet.id}</Description> 
<Description term="位置">{smartPallet.location}</Description> 
<Description term="联系电话">{smartPallet.contactNumber}</Description> 
<Description term="总面积">{smartPallet.totalArea}</Description> 
<Description term="纬度">{smartPallet.latitude}</Description> 
<Description term="经度">{smartPallet.longitude}</Description> 
<Description term="更新于">{ moment(smartPallet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = smartPallet => {
  const {SmartPalletBase} = GlobalComponents
  return <PermissionSetting targetObject={smartPallet}  targetObjectMeta={SmartPalletBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SmartPalletPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  smartPallet = this.props.smartPallet
    const { id,displayName, goodsCount } = smartPallet
    const  returnURL = `/smartPallet/${id}/workbench`
    const cardsData = {cardsName:"智能托盘",cardsFor: "smartPallet",cardsSource: smartPallet,displayName,returnURL,
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
  smartPallet: state._smartPallet,
}))(Form.create()(SmartPalletPermission))

