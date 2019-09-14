

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './QuickLink.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (quickLink,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{quickLink.id}</Description> 
<Description term="名称">{quickLink.name}</Description> 
<Description term="图标">{quickLink.icon}</Description> 
<Description term="链接的目标">{quickLink.linkTarget}</Description> 
<Description term="创建时间">{ moment(quickLink.createTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = quickLink => {
  const {QuickLinkBase} = GlobalComponents
  return <PermissionSetting targetObject={quickLink}  targetObjectMeta={QuickLinkBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class QuickLinkPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  quickLink = this.props.quickLink
    const { id,displayName,  } = quickLink
    const  returnURL = `/quickLink/${id}/dashboard`
    const cardsData = {cardsName:"快速链接",cardsFor: "quickLink",cardsSource: quickLink,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  quickLink: state._quickLink,
}))(Form.create()(QuickLinkPermission))

