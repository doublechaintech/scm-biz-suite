

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
import styles from './SecUserBlocking.profile.less'
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
const internalSummaryOf = (secUserBlocking,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{secUserBlocking.id}</Description> 
<Description term="谁">{secUserBlocking.who}</Description> 
<Description term="块时间">{ moment(secUserBlocking.blockTime).format('YYYY-MM-DD')}</Description> 
<Description term="评论">{secUserBlocking.comments}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = secUserBlocking => {
  const {SecUserBlockingBase} = GlobalComponents
  return <PermissionSetting targetObject={secUserBlocking}  targetObjectMeta={SecUserBlockingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SecUserBlockingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  secUserBlocking = this.props.secUserBlocking
    const { id,displayName, secUserCount } = secUserBlocking
    const  returnURL = `/secUserBlocking/${id}/dashboard`
    const cardsData = {cardsName:"用户屏蔽",cardsFor: "secUserBlocking",cardsSource: secUserBlocking,displayName,returnURL,
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
  secUserBlocking: state._secUserBlocking,
}))(Form.create()(SecUserBlockingPermission))

